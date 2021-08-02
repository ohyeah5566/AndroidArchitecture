package com.ohyeah5566.model

data class Post(
    val postLink: String,
    val title: String,
    val subreddit: String,
    val url: String,
    val author: String,
    val ups: Int,
)