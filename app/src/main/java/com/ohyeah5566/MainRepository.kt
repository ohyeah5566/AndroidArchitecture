package com.ohyeah5566

import com.ohyeah5566.model.Post

class MainRepository(
    val service: PostService
) {
    suspend fun getPosts(subReddit: String): List<Post> {
        return service.getPost(subReddit).memes
    }

    suspend fun upsLessThen(post: Post) {

    }

    suspend fun upsMoreTen(post: Post) {

    }
}