package com.ohyeah5566.db

import androidx.room.*
import com.ohyeah5566.model.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPost(post: Post)

    @Delete
    suspend fun deletePost(post: Post)

    /**
     * 只要table一有變化就會觸發更新
     * 看起來是內部有做emit的動作?
     */
    @Query("SELECT * From posts")
    fun getAll(): Flow<List<Post>>

}