package com.ougi.mediaplayer.contentimpl.data.mapper

import android.database.Cursor
import android.provider.MediaStore
import com.ougi.mediaplayer.contentimpl.data.model.LocalFile

internal fun Cursor.mapToLocalFile(): LocalFile =
    use { cursor ->
        val idColumn = cursor.getColumnIndex(MediaStore.Files.FileColumns._ID)
        val id = cursor.getString(idColumn)

        val mimeTypeColumn =
            cursor.getColumnIndex(MediaStore.Files.FileColumns.MIME_TYPE)
        val mimeType = cursor.getString(mimeTypeColumn)

        LocalFile(
            id = id,
            mimeType = mimeType,
        )
    }