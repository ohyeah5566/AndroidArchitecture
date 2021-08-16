package com.ohyeah5566

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ohyeah5566.data.MainRepository
import com.ohyeah5566.data.Post
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    @Test
    fun testPostFavoriteClick() {
        val repository = mockk<MainRepository>(relaxed = true)
        val viewModel = MainViewModel(repository, testDispatcher)
        val post = Post(
            "https://postLink.com",
            "title",
            "memes",
            "https://url.com",
            "me",
            100
        )

        post.favorite = true
        viewModel.postFavoriteClick(post)
        coVerify { repository.saveLikedPost(post) }

        post.favorite = false
        viewModel.postFavoriteClick(post)
        coVerify { repository.deleteLikedPost(post) }
    }

    @Test
    fun testGetPost(){
        val repository = mockk<MainRepository>(relaxed = true)
        val viewModel = MainViewModel(repository, testDispatcher)

        viewModel.loadPost("sub")
        coVerify { repository.getPosts("sub") }

        viewModel.loadPost("liked")
        coVerify { repository.getLikedPosts() }
    }
}