package com.ohyeah5566

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ohyeah5566.db.PostDao
import com.ohyeah5566.db.PostDatabase
import com.ohyeah5566.model.Post
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
 * 測試local db
 * 需要實體手機 所以放在androidTest
 */
@RunWith(AndroidJUnit4::class)
class RoomDatabaseTest {

    private lateinit var postDao: PostDao
    private lateinit var db: PostDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, PostDatabase::class.java
        ).build()
        postDao = db.transactionDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() = runBlocking {
        val post = Post(
            "https://postLink.com",
            "title",
            "memes",
            "https://url.com",
            "me",
            100
        )

        postDao.addPost(post)
        var posts = postDao.getAll()
        assert(posts[0].title == "title")
        postDao.deletePost(post)
        posts = postDao.getAll()
        assert(posts.isEmpty())
    }
}