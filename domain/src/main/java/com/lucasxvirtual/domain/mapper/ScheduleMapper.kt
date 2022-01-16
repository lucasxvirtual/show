package com.lucasxvirtual.domain.mapper

import com.lucasxvirtual.data.model.ScheduleResponse
import com.lucasxvirtual.domain.model.Schedule
import javax.inject.Inject

class ScheduleMapper @Inject constructor() {

    fun map(response : ScheduleResponse?) : Schedule? {
        if(response == null)
            return null
        return Schedule(
            time = response.time,
            days = response.days
        )
    }

}