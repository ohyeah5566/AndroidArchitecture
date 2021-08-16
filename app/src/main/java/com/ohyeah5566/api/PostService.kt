package com.ohyeah5566.api

import com.ohyeah5566.data.BaseResponse
import com.ohyeah5566.data.Post
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {
    @GET("gimme/{subReddit}/5")
    suspend fun getPost(@Path("subReddit") subReddit: String): BaseResponse<List<Post>>
}

fun getPostService(): PostService {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val logInterceptor = HttpLoggingInterceptor()
    logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder().addInterceptor(logInterceptor).build()

    return Retrofit.Builder()
        .baseUrl("https://meme-api.herokuapp.com/")
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(PostService::class.java)
}
