package com.ohyeah5566.model

import androidx.annotation.DrawableRes
import com.ohyeah5566.R

data class Post(
    val postLink: String,
    val title: String,
    val subreddit: String,
    val url: String,
    val author: String,
    val ups: Int,
) {

    /**
     * 因為result沒有subReddit icon資訊
     * 所以這邊需要寫死
     */
    @DrawableRes
    fun getSubRedditIcon(): Int {
        return when (subreddit) {
            "memes" -> R.drawable.ic_memes
            else -> -1
        }

    }

}