package com.ohyeah5566

/**
 *  找不到amiibo會回傳的資料格式
 *  ex:
 *    {
 *        "code": 404,
 *        "error": "The requested URL was not found on the server. If you entered the URL manually please check your spelling and try again."
 *     }
 */
data class ErrorResponse (
    val code: Int ,
    val error: String
)
