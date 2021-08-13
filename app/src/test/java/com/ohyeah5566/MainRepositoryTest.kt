package com.ohyeah5566

import com.ohyeah5566.db.PostDao
import com.ohyeah5566.model.Post
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

import org.junit.Test

class MainRepositoryTest {

    @Test
    fun getLikedPosts() = runBlocking {
        val service = mockk<PostService>()
        val db = mockk<PostDao>(relaxed = true)
        every { db.getAll() } returns flow {
            //第一個沒有favorite , 第二個有favorite
            emit(listOf(
                Post(
                    "https://postLink.com",
                    "title",
                    "memes",
                    "https://url.com",
                    "me",
                    100
                ), Post(
                    "https://postLink.comT",
                    "titleT",
                    "memesT",
                    "https://url.comT",
                    "meT",
                    1001
                ).apply {
                    favorite = true
                }
            ))
        }
        val repository = MainRepository(service, db)
        val list = repository.getLikedPosts().first()
        assert(list[0].title == "titleT")
        assert(list.size == 1)
    }
}