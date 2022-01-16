package com.lucasxvirtual.domain.mapper

import com.lucasxvirtual.data.model.ShowResponse
import com.lucasxvirtual.domain.model.Show
import javax.inject.Inject

class ShowMapper @Inject constructor (
    private val imageMapper : ImageMapper,
    private val scheduleMapper: ScheduleMapper)
{

    fun map(response: List<ShowResponse>?) : List<Show>? {
        if(response == null)
            return null
        return response.map { map(it) }
    }

    fun map(response: ShowResponse) : Show {
        return Show(
            id = response.id,
            name = response.name,
            image = imageMapper.map(response.image),
            schedule = scheduleMapper.map(response.schedule),
            summary = response.summary,
            genres = response.genres
        )
    }

}