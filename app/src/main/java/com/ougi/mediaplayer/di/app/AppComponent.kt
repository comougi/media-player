package com.ougi.mediaplayer.di.app

import android.content.Context
import com.ougi.mediaplayer.presentation.App
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [AppModule::class]
)
internal interface AppComponent {

    fun inject(app: App)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }

}