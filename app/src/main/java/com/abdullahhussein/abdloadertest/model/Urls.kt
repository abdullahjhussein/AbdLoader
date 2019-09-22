package com.abdullahhussein.abdloadertest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Urls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val medium: String,
    val large: String,
    val thumb: String
) : Parcelable {
    constructor() : this("", "", "", "", "", "", "")
}
