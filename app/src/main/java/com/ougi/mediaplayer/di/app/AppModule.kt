package com.ougi.mediaplayer.di.app

import com.ougi.mediaplayer.di.features.content.ContentFeatureModule
import dagger.Module

@Module(
    includes = [ContentFeatureModule::class]
)
internal interface AppModule