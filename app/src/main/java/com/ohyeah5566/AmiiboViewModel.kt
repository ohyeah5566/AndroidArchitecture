package com.ohyeah5566

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AmiiboViewModel(private val amiiboRepository: AmiiboRepository) : ViewModel() {
    private val _amiiboLists = MutableLiveData<List<Amiibo>>()
    val amiiboLists: LiveData<List<Amiibo>>
        get() = _amiiboLists

    fun searchAmiibo(keyword: String) {
        viewModelScope.launch {
            _amiiboLists.value = amiiboRepository.getAmiiboList(keyword)
        }
    }
}