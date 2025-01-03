package com.ougi.mediaplayer.contentimpl

import com.ougi.mediaplayer.contentapi.ContentApi
import com.ougi.mediaplayer.contentimpl.domain.usecase.GetChangedFilesUseCase
import javax.inject.Inject

internal class ContentImpl @Inject constructor(
    getChangedFilesUseCase: GetChangedFilesUseCase
) : ContentApi {

    override val changedContentFiles = getChangedFilesUseCase.changedFilesFlow

}