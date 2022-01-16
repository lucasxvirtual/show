package com.lucasxvirtual.domain.mapper

import com.lucasxvirtual.data.model.ImageResponse
import com.lucasxvirtual.domain.model.Image
import javax.inject.Inject

class ImageMapper @Inject constructor() {

    fun map(response : ImageResponse?) : Image? {
        if(response == null)
            return null
        return Image(
            original = response.original,
            medium = response.medium
        )
    }

}