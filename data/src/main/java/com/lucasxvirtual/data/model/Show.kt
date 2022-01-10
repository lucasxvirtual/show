package com.lucasxvirtual.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Show(
    val id : Int,
    val name : String,
    val image : Image?,
    val schedule : Schedule?,
    val summary : String,
    val genres : List<String>?
) : Parcelable