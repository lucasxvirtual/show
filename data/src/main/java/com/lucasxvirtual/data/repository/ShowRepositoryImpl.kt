package com.lucasxvirtual.data.repository

import com.lucasxvirtual.data.model.SearchResponse
import com.lucasxvirtual.data.model.Season
import com.lucasxvirtual.data.model.Show
import com.lucasxvirtual.data.remote.Resource
import com.lucasxvirtual.data.remote.ShowService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ShowRepositoryImpl @Inject constructor(
    private val showService: ShowService
) : ShowRepository {

    override suspend fun getShows(page: Int): Flow<Resource<List<Show>>> {
        return flow {
            emit(Resource.loading(null))
            val shows = showService.getShows(page)
            emit(Resource.success(shows))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun searchShows(query: String): Flow<Resource<List<SearchResponse>>> {
        return flow {
            emit(Resource.loading(null))
            val search = showService.searchShow(query)
            emit(Resource.success(search))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getSeasonsOfShow(showId: Int): Flow<Resource<List<Season>>> {
        return flow {
            emit(Resource.loading(null))
            val shows = showService.getSeasonsOfShow(showId)
            emit(Resource.success(shows))
        }.flowOn(Dispatchers.IO)
    }
}