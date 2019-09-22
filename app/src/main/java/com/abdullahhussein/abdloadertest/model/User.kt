package com.abdullahhussein.abdloadertest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: String,
    val username: String,
    val name: String,
    val profile_image: Urls
) : Parcelable {
    constructor() : this("", "", "", Urls())
}
