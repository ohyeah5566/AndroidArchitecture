package com.ohyeah5566.data

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ohyeah5566.R

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey
    val postLink: String,
    val title: String,
    val subreddit: String,
    val url: String,
    val author: String,
    val ups: Int,
    var favorite: Boolean = false
) {


    /**
     * 因為result沒有subReddit icon資訊
     * 所以這邊需要寫死
     */
    @DrawableRes
    fun getSubRedditIcon() = when (subreddit) {
        "memes" -> R.drawable.ic_memes
        else -> -1
    }


}