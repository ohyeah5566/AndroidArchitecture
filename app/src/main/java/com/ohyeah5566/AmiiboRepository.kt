package com.ohyeah5566

import javax.inject.Inject

/**
 *  改用Inject的方式取得amiiboService
 */
class AmiiboRepository @Inject constructor(
    private val service: AmiiboService
) {
    suspend fun getAmiiboList(name: String): ResultWrapper<AmiiboResponse> {
        return safeApiCall { service.getAmiiboList(name) }   //TODO 為什麼safeApiCall的參數位置對調 就沒辦法這樣寫
    }
}