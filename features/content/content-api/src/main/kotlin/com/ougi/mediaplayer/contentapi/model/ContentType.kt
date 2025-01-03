package com.ougi.mediaplayer.contentapi.model

sealed interface ContentType {

    sealed class Media(val mimeTypePrefix: String) : ContentType {
        data object Audio : Media("audio")
        data object Video : Media("video")
        data object Image : Media("image")
    }

    //TODO : Далее расширить количество узнаваемых типов файлов
    sealed interface File : ContentType {
        data object Document : File
    }
}