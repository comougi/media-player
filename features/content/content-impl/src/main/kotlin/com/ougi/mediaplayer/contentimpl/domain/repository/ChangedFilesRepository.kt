package com.ougi.mediaplayer.contentimpl.domain.repository

import com.ougi.mediaplayer.contentimpl.data.model.LocalFile
import kotlinx.coroutines.flow.Flow

internal interface ChangedFilesRepository {

    val changedFilesFlow: Flow<List<LocalFile>>

}