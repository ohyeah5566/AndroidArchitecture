package com.ohyeah5566

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AmiiboService {

    @GET("amiibo/")
    suspend fun getAmiiboList(@Query("name") name: String): AmiiboResponse
}