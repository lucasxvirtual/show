package com.lucasxvirtual.show.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasxvirtual.data.remote.Resource
import com.lucasxvirtual.domain.GetShowListUseCase
import com.lucasxvirtual.domain.model.Show
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowViewModel @Inject constructor(private val getShowListUseCase: GetShowListUseCase) : ViewModel() {

    private val _showList = MutableStateFlow(
        Resource.loading<List<Show>>(null)
    )

    val showList : StateFlow<Resource<List<Show>>>
        get() = _showList

    init {
        getShowList(0)
    }

    fun getShowList(page : Int){
        viewModelScope.launch {
            getShowListUseCase.execute(page).collect {
                _showList.value = it
            }
        }
    }

}