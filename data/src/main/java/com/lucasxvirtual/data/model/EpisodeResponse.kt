package com.lucasxvirtual.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EpisodeResponse(
    val id : Int,
    val name : String?,
    val number : Int,
    val season : Int,
    val summary : String,
    val image : ImageResponse?
) : Parcelable