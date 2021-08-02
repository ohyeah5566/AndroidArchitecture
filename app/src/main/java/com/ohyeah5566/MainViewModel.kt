package com.ohyeah5566

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ohyeah5566.model.Post
import kotlinx.coroutines.launch

class MainViewModel(
    val repository: MainRepository
) : ViewModel() {
    private val _memes = MutableLiveData<List<Post>>()
    val meme : LiveData<List<Post>> = _memes

    fun loadPost(subReddit:String){
        viewModelScope.launch {
            _memes.value = repository.getPosts(subReddit)
        }
    }
}