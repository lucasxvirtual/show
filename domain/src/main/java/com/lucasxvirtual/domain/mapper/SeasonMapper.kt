package com.lucasxvirtual.domain.mapper

import com.lucasxvirtual.data.model.SeasonResponse
import com.lucasxvirtual.domain.model.Season
import javax.inject.Inject

class SeasonMapper @Inject constructor () {

    fun map(response: List<SeasonResponse>?) : List<Season>? {
        if(response == null)
            return null
        return response.map { map(it) }
    }

    fun map(response: SeasonResponse) : Season {
        return Season(
            id = response.id,
            name = response.name,
            number = response.number
        )
    }

}