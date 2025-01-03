package com.ougi.mediaplayer.contentapi

import com.ougi.mediaplayer.contentapi.model.ContentFile
import kotlinx.coroutines.flow.Flow

interface ContentApi {

    val changedContentFiles: Flow<List<ContentFile>>

}