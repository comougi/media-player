package com.ougi.mediaplayer.contentimpl.domain.usecase

import com.ougi.mediaplayer.contentapi.model.ContentFile
import com.ougi.mediaplayer.contentimpl.data.model.LocalFile
import com.ougi.mediaplayer.contentimpl.domain.mapper.mapToContentFile
import com.ougi.mediaplayer.contentimpl.domain.repository.ChangedFilesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal interface GetChangedFilesUseCase {

    val changedFilesFlow: Flow<List<ContentFile>>

}

internal class GetChangedFilesUseCaseImpl @Inject constructor(
    changedFilesRepository: ChangedFilesRepository
) : GetChangedFilesUseCase {

    override val changedFilesFlow = changedFilesRepository
        .changedFilesFlow
        .map { changedFiles -> changedFiles.map(LocalFile::mapToContentFile) }
        .catch { emitAll(emptyFlow()) }

}