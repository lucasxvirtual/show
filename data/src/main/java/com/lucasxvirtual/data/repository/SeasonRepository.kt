package com.lucasxvirtual.data.repository

import com.lucasxvirtual.data.model.Episode
import com.lucasxvirtual.data.remote.Resource
import kotlinx.coroutines.flow.Flow

interface SeasonRepository {

    suspend fun getEpisodesOfSeason(seasonId : Int) : Flow<Resource<List<Episode>>>

}