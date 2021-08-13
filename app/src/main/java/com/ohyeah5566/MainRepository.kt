package com.ohyeah5566

import com.ohyeah5566.db.PostDao
import com.ohyeah5566.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class MainRepository(
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
