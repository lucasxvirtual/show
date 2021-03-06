package com.lucasxvirtual.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Show(
    val id : Int,
    val name : String,
    val image : Image?,
    val schedule : Schedule?,
    val summary : String,
    val genres : List<String>?,
    var seasons : List<Season>? = null
) : Parcelable