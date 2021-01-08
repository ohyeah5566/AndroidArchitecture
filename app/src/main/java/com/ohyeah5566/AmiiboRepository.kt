package com.ohyeah5566

import javax.inject.Inject

/**
 *  改用Inject的方式取得amiiboService
 */
class AmiiboRepository @Inject constructor(
    private val service: AmiiboService
) {

    suspend fun getAmiiboList(name: String): List<Amiibo> {
        try {
            val result = service.getAmiiboList(name)
            return result.amiibo
        } catch (ex: Throwable) {
            //TODO
        }

        return emptyList()
    }
}