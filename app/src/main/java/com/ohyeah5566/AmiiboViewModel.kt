package com.ohyeah5566

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.launch

/**
 *   這邊修改就按照官網上的hilt for viewModel
 *   新增 @ViewModelInject constructor 和 @Assisted即可
 *   https://developer.android.com/training/dependency-injection/hilt-android?authuser=1
 */
class AmiiboViewModel @ViewModelInject constructor(
    private val amiiboRepository: AmiiboRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _amiiboLists = MutableLiveData<List<Amiibo>>()
    val amiiboLists: LiveData<List<Amiibo>>
        get() = _amiiboLists

    fun searchAmiibo(keyword: String) {
        viewModelScope.launch {
            _amiiboLists.value = amiiboRepository.getAmiiboList(keyword)
        }
    }
}