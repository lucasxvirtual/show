package com.lucasxvirtual.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShowResponse(
    val id : Int,
    val name : String,
    val image : ImageResponse?,
    val schedule : ScheduleResponse?,
    val summary : String,
    val genres : List<String>?
) : Parcelable