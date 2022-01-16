package com.lucasxvirtual.domain

import com.lucasxvirtual.data.model.EpisodeResponse
import com.lucasxvirtual.data.model.ShowResponse
import com.lucasxvirtual.data.remote.Resource
import com.lucasxvirtual.data.remote.Status
import com.lucasxvirtual.data.repository.SeasonRepository
import com.lucasxvirtual.data.repository.ShowRepository
import com.lucasxvirtual.domain.mapper.EpisodeMapper
import com.lucasxvirtual.domain.mapper.SeasonMapper
import com.lucasxvirtual.domain.mapper.ShowMapper
import com.lucasxvirtual.domain.model.Show
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetShowDetailUseCase @Inject constructor(
    private val showRepository: ShowRepository,
    private val seasonRepository: SeasonRepository,
    private val seasonMapper: SeasonMapper,
    private val episodeMapper: EpisodeMapper
)
{

    suspend fun execute(show : Show, currentSeason : Int = 1) : Flow<Resource<Show>>{
        return flow {
            showRepository.getSeasonsOfShow(show.id).collect { seasonFlow ->
                when(seasonFlow.status){
                    Status.SUCCESS -> {
                        val seasonData = seasonMapper.map(seasonFlow.data)
                        if(seasonData.isNullOrEmpty()){
                            emit(Resource.success(show))
                        } else {
                            getEpisodesOfSeason(seasonData[0].id).collect {
                                show.seasons = seasonData
                                show.seasons!![0].episodes = episodeMapper.map(it)
                                emit(Resource.success(show))
                            }
                        }
                    }
                    Status.LOADING -> {
                        emit(Resource.loading(null))
                    }
                    Status.ERROR -> {
                        emit(Resource.error(seasonFlow.message!!, null))
                    }
                }
            }
        }
    }

    private suspend fun getEpisodesOfSeason(seasonId : Int) : Flow<List<EpisodeResponse>> {
        return flow {
            seasonRepository.getEpisodesOfSeason(seasonId).collect {
                if(it.status == Status.SUCCESS){
                    emit(it.data!!)
                }
            }
        }
    }

}