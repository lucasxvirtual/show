package com.lucasxvirtual.domain

import com.lucasxvirtual.data.remote.Resource
import com.lucasxvirtual.data.remote.Status
import com.lucasxvirtual.data.repository.ShowRepository
import com.lucasxvirtual.domain.mapper.ShowMapper
import com.lucasxvirtual.domain.model.Show
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetShowListUseCase @Inject constructor(
    private val showRepository: ShowRepository,
    private val showMapper: ShowMapper
) {

    suspend fun execute(page : Int) : Flow<Resource<List<Show>>> {
        return showRepository.getShows(page).map {
            when(it.status){
                Status.SUCCESS -> {
                    Resource.success(showMapper.map(it.data))
                }
                Status.LOADING -> {
                    Resource.loading(null)
                }
                Status.ERROR -> {
                    Resource.error(it.message!!, null)
                }
            }
        }
    }

}