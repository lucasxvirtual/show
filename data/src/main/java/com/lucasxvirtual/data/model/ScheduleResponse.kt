package com.lucasxvirtual.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScheduleResponse(
    val time : String,
    val days : List<String>
) : Parcelable