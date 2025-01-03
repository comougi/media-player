package com.ougi.mediaplayer.contentimpl.domain.repository

import com.ougi.mediaplayer.contentimpl.data.model.LocalFile

internal interface DownloadsContentRepository {

    fun getDownloadsContents(
        page: Int,
        itemsCount: Int
    ): List<LocalFile>

}