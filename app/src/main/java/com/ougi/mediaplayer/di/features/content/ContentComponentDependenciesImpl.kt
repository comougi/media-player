package com.ougi.mediaplayer.di.features.content

import android.content.Context
import com.ougi.mediaplayer.contentimpl.di.ContentComponentDependencies
import javax.inject.Inject

internal class ContentComponentDependenciesImpl @Inject constructor(
    override val context: Context
) : ContentComponentDependencies