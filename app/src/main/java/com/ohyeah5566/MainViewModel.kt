package com.ohyeah5566

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ohyeah5566.model.Post
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    val repository: MainRepository,
    val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private val _memes = MutableLiveData<List<Post>>()
    val meme: LiveData<List<Post>> = _memes

    fun loadPost(subReddit: String) {
        viewModelScope.launch {
            _memes.value = repository.getPosts(subReddit)
        }
    }

    fun doSomethingAccordingUps(post: Post) {
        viewModelScope.launch(dispatcher) {
            if (post.ups > 10) {
                repository.upsMoreTen(post)
            } else {
                repository.upsLessThen(post)
            }
        }
    }
}