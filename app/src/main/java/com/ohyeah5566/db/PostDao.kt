package com.ohyeah5566.db

import androidx.room.*
import com.ohyeah5566.model.Post

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPost(post: Post)

    @Delete
    suspend fun deletePost(post: Post)

    @Query("SELECT * From posts")
    suspend fun getAll(): List<Post>

}