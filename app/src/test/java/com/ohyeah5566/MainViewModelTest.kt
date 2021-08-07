package com.ohyeah5566

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ohyeah5566.model.Post
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()
    val testDispatcher = TestCoroutineDispatcher()

    @Test
    fun testUps() = runBlocking {
        val repository = mockk<MainRepository>(relaxed = true)
        val viewModel = MainViewModel(repository)
        val post = Post(
            "link",
            "title",
            "subReddit",
            "url",
            "author",
            100
        )

        viewModel.doSomethingAccordingUps(post)
        coVerify { repository.upsMoreTen(post) }
    }
}