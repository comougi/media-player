package com.ougi.mediaplayer.contentimpl.di

import com.ougi.mediaplayer.contentapi.ContentApi

object ContentApiProvider {

    fun getApi(dependencies: ContentComponentDependencies): ContentApi =
        DaggerContentComponent.factory()
            .create(dependencies)
            .getContentApi()
}