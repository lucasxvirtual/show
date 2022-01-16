package com.lucasxvirtual.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Season(
    val id : Int,
    val number : Int,
    val name : String?,
    var episodes : List<Episode>? = null
) : Parcelable