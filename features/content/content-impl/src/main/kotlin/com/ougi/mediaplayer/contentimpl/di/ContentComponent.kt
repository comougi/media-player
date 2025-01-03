package com.ougi.mediaplayer.contentimpl.di

import com.ougi.mediaplayer.contentapi.ContentApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [ContentComponentDependencies::class],
    modules = [ContentModule::class]
)
internal interface ContentComponent {

    fun getContentApi(): ContentApi

    @Component.Factory
    interface Factory {
        fun create(dependencies: ContentComponentDependencies): ContentComponent
    }
}