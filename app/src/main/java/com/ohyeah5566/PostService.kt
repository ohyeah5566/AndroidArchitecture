package com.ohyeah5566

import com.ohyeah5566.model.Post
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {
    @GET("gimme/{subReddit}")
    suspend fun getPost(@Path("subReddit") subReddit: String): BaseResponse<List<Post>>
}

fun getPostService(): PostService {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    return Retrofit.Builder()
        .baseUrl("https://meme-api.herokuapp.com/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(PostService::class.java)
}
