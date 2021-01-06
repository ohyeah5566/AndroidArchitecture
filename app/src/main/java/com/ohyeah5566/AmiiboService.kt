package com.ohyeah5566

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val service: AmiiboService by lazy {
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    Retrofit.Builder()
        .client(client)
        .baseUrl("https://www.amiiboapi.com/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(AmiiboService::class.java)
}

fun getAmiiboService(): AmiiboService = service

interface AmiiboService {
    @GET("amiibo/")
    suspend fun getAmiiboList(@Query("gameseries") name: String): AmiiboResponse
}