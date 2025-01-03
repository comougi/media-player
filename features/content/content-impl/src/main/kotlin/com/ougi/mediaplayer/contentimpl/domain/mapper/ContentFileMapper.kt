package com.ougi.mediaplayer.contentimpl.domain.mapper

import com.ougi.mediaplayer.contentapi.model.ContentFile
import com.ougi.mediaplayer.contentapi.model.ContentType
import com.ougi.mediaplayer.contentimpl.data.model.LocalFile

internal fun LocalFile.mapToContentFile(): ContentFile =
    ContentFile(
        id = id,
        contentType =
        when {
            mimeType.startsWith(ContentType.Media.Audio.mimeTypePrefix) -> ContentType.Media.Audio
            mimeType.startsWith(ContentType.Media.Video.mimeTypePrefix) -> ContentType.Media.Video
            mimeType.startsWith(ContentType.Media.Image.mimeTypePrefix) -> ContentType.Media.Image
            else -> ContentType.File.Document
        }
    )

