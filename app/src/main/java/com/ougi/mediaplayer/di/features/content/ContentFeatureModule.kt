package com.ougi.mediaplayer.di.features.content

import com.ougi.mediaplayer.contentapi.ContentApi
import com.ougi.mediaplayer.contentimpl.di.ContentApiProvider
import com.ougi.mediaplayer.contentimpl.di.ContentComponentDependencies
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
internal interface ContentFeatureModule {

    @Binds
    fun bindContentComponentDependencies(
        dependencies: ContentComponentDependenciesImpl
    ): ContentComponentDependencies

    companion object {
        @Provides
        fun provideContentApi(
            dependencies: ContentComponentDependencies
        ): ContentApi = ContentApiProvider.getApi(dependencies)
    }

}