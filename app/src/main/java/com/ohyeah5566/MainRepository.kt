package com.ohyeah5566

import com.ohyeah5566.db.PostDao
import com.ohyeah5566.model.Post

class MainRepository(
    val service: PostService,
    val db: PostDao
) {
    suspend fun getPosts(subReddit: String): List<Post> {
        return service.getPost(subReddit).memes
    }

    suspend fun saveLikedPost(post: Post) {
        db.addPost(post)
    }

    suspend fun deleteLikedPost(post:Post){
        db.deletePost(post)
    }
}
