package com.ohyeah5566

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ohyeah5566.model.Post
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
    val repository: MainRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {
    private val _memes = MutableLiveData<List<Post>>()
    val meme: LiveData<List<Post>> = _memes

    fun loadPost(subReddit: String) {
        viewModelScope.launch(dispatcher) {
            if (subReddit == "liked") {
                repository.getLikedPosts().collect {
                    _memes.value = it
                }
            } else {
                repository.getPosts(subReddit).collect {
                    _memes.value = it
                }
            }
        }
    }

    fun postFavoriteClick(post: Post) {
        viewModelScope.launch(dispatcher) {
            if (post.favorite) {
                repository.saveLikedPost(post)
            } else {
                repository.deleteLikedPost(post)
            }
        }
    }
}