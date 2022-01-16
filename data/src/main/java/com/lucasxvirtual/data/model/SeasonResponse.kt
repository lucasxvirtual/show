package com.lucasxvirtual.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SeasonResponse(
    val id : Int,
    val number : Int,
    val name : String?
) : Parcelable