package com.ougi.mediaplayer.di

import dagger.Component

@Component(
    modules = [AppModule::class]
)
internal interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

}