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
    val amiiboLists: LiveData<List<Amiibo>> = _amiiboLists

    //這兩個一次性的資料，要用Event包起來，避免畫面重建時，再次觸發
    private val _errorMessage = MutableLiveData<Event<String>>()
    val errorMessage: LiveData<Event<String>>
        get() = _errorMessage
    private val _networkErrorEvent = MutableLiveData<Event<Int>>()
    val networkErrorEvent: LiveData<Event<Int>>
        get() = _networkErrorEvent

    fun searchAmiibo(keyword: String) {
        viewModelScope.launch {
            val amiiboResultWrapper = amiiboRepository.getAmiiboList(keyword)
            when (amiiboResultWrapper) {
                is ResultWrapper.Success -> _amiiboLists.value = amiiboResultWrapper.value.amiibo
                is ResultWrapper.GenericError -> _errorMessage.value = Event(amiiboResultWrapper.error?.error ?: "")
                ResultWrapper.NetworkError -> showNetworkError() //sealed的object可以不用is
            }
        }
    }

    private fun showNetworkError(){
        //google不建議因為getString而在這裡用context
        //https://medium.com/androiddevelopers/locale-changes-and-the-androidviewmodel-antipattern-84eb677660d9
        _networkErrorEvent.value = Event(R.string.net_work_error_msg)
    }
}