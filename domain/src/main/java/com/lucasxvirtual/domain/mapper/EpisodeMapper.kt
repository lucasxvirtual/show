package com.lucasxvirtual.domain.mapper

import com.lucasxvirtual.data.model.EpisodeResponse
import com.lucasxvirtual.domain.model.Episode
import javax.inject.Inject

class EpisodeMapper @Inject constructor(private val imageMapper: ImageMapper) {

    fun map(response: List<EpisodeResponse>?) : List<Episode>? {
        if(response == null)
            return null
        return response.map { map(it) }
    }

    fun map(response: EpisodeResponse) : Episode {
        return Episode(
            id = response.id,
            name = response.name,
            number = response.number,
            season = response.season,
            summary = response.summary,
            image = imageMapper.map(response.image)
        )
    }

}