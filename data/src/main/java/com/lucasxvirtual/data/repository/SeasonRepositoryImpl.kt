package com.lucasxvirtual.data.repository

import com.lucasxvirtual.data.model.Episode
import com.lucasxvirtual.data.remote.Resource
import com.lucasxvirtual.data.remote.SeasonService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SeasonRepositoryImpl @Inject constructor(
    private val seasonService: SeasonService
) : SeasonRepository {

    override suspend fun getEpisodesOfSeason(seasonId: Int) : Flow<Resource<List<Episode>>> {
        return flow {
            emit(Resource.loading(null))
            val shows = seasonService.getEpisodesOfSeason(seasonId)
            emit(Resource.success(shows))
        }.flowOn(Dispatchers.IO)
    }
}