package com.ougi.mediaplayer.contentimpl.data.repository

import android.content.ContentResolver
import android.database.ContentObserver
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.HandlerThread
import android.provider.MediaStore
import com.ougi.mediaplayer.contentimpl.data.mapper.mapToLocalFile
import com.ougi.mediaplayer.contentimpl.data.model.LocalFile
import com.ougi.mediaplayer.contentimpl.domain.repository.ChangedFilesRepository
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch

internal class ChangedFilesRepositoryImpl(
    private val contentResolver: ContentResolver,
) : ChangedFilesRepository {

    override val changedFilesFlow = callbackFlow {
        val contentObserver = createContentObserver()

        contentResolver.registerContentObserver(
            MediaStore.Files.getContentUri(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) MediaStore.VOLUME_EXTERNAL
                else EXTERNAL_VOLUME_NAME
            ),
            true,
            contentObserver
        )

        awaitClose { contentResolver.unregisterContentObserver(contentObserver) }
    }
        .catch { emit(emptyList()) }

    private fun ProducerScope<List<LocalFile>>.createContentObserver() =
        object : ContentObserver(Handler(HandlerThread(CONTENT_OBSERVER_THREAD_NAME).looper)) {

            override fun onChange(selfChange: Boolean, uris: MutableCollection<Uri>, flags: Int) {
                super.onChange(selfChange, uris, flags)
                uris
                    .mapNotNull { uri ->
                        runCatching {
                            createQuery(uri)?.run(Cursor::mapToLocalFile)
                        }
                            .getOrNull()
                    }
                    .let(::trySendBlocking)
            }

        }

    private fun createQuery(uri: Uri) =
        contentResolver.query(
            uri,
            null,
            null,
            null,
            null
        )

    private companion object {
        private const val EXTERNAL_VOLUME_NAME = "external"
        private const val CONTENT_OBSERVER_THREAD_NAME = "CONTENT_OBSERVER_THREAD"
    }
}