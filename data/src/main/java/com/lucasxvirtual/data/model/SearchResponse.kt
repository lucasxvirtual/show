package com.lucasxvirtual.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchResponse(
    val show : Show
) : Parcelable