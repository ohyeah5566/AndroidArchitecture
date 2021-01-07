package com.ohyeah5566


class AmiiboRepository(private val service: AmiiboService) {

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