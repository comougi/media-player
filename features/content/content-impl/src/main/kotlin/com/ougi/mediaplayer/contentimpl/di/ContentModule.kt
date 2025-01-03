package com.ougi.mediaplayer.contentimpl.di

import android.content.ContentResolver
import android.content.Context
import com.ougi.mediaplayer.contentapi.ContentApi
import com.ougi.mediaplayer.contentimpl.ContentImpl
import com.ougi.mediaplayer.contentimpl.data.repository.ChangedFilesRepositoryImpl
import com.ougi.mediaplayer.contentimpl.domain.repository.ChangedFilesRepository
import com.ougi.mediaplayer.contentimpl.domain.usecase.GetChangedFilesUseCase
import com.ougi.mediaplayer.contentimpl.domain.usecase.GetChangedFilesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
internal interface ContentModule {

    @Binds
    fun bindContentApi(impl: ContentImpl): ContentApi

    @Binds
    fun bindChangedFilesRepository(repository: ChangedFilesRepositoryImpl): ChangedFilesRepository

    @Binds
    fun bindGetChangedFilesUseCase(useCase: GetChangedFilesUseCaseImpl): GetChangedFilesUseCase

    companion object {
        @Provides
        fun provideContentResolver(context: Context): ContentResolver = context.contentResolver
    }
}