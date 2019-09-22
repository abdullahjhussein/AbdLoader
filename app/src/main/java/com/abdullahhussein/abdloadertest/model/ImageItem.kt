package com.abdullahhussein.abdloadertest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageItem(
    val id: String,
    val created_at: String,
    val width: Int,
    val height: Int,
    val user: User,
    val urls: Urls
) : Parcelable {
    constructor() : this("", "", 0, 0,
        User(),
        Urls()
    )
}