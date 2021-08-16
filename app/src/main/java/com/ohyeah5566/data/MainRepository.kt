package com.ohyeah5566.data

import com.ohyeah5566.api.PostService
import com.ohyeah5566.db.PostDao
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

class MainRepository @Inject constructor(
    val service: PostService,
    val db: PostDao
) {
    fun getPosts(subReddit: String): Flow<List<Post>> = flow {
        emit(service.getPost(subReddit).memes)
    }

    /**
     * 假裝getAll拿到的資料可能不全是liked的
     * 所以再多一個filter的動作
     * 模擬拿到的資料要額外做處理的情況
     */
    fun getLikedPosts(): Flow<List<Post>> {
        return db.getAll().map { list ->
            list.filter { post ->
                post.favorite
            }
        }
    }

    suspend fun saveLikedPost(post: Post) {
        db.addPost(post)
    }

    suspend fun deleteLikedPost(post: Post) {
        db.deletePost(post)
    }
}
