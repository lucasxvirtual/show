package com.lucasxvirtual.data.repository

import com.lucasxvirtual.data.model.SearchResponse
import com.lucasxvirtual.data.model.SeasonResponse
import com.lucasxvirtual.data.model.ShowResponse
import com.lucasxvirtual.data.remote.Resource
import kotlinx.coroutines.flow.Flow


interface ShowRepository {

    suspend fun getShows(page : Int) : Flow<Resource<List<ShowResponse>>>

    suspend fun searchShows(query : String) : Flow<Resource<List<SearchResponse>>>

    suspend fun getSeasonsOfShow(showId : Int) : Flow<Resource<List<SeasonResponse>>>

}