package com.ohyeah5566

import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

/**
 *  https://medium.com/@douglas.iacovelli/how-to-handle-errors-with-retrofit-and-coroutines-33e7492a912
 *  call retrofit method的方式都透過下面的fun
 *  可以將結果不管是成功A格式,失敗B格式,網路問題的result
 *  透過以下的function轉成ResultWrapper<T>
 *
 *  會需要多傳dispatcher的方式 是因為寫unit test的需要
 *  不過可以用kotlin的特性，讓一般呼叫時只需要apiCall即可
 */
suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> {
                    //網路問題的Exception ,ex沒開網路,timeOut
                    ResultWrapper.NetworkError
                }
                is HttpException -> {
                    //retrofit convert 失敗時 會丟HttpException,或其他non-2xx HTTP response
                    val code = throwable.code()
                    val errorResponse = convertErrorBody(throwable)
                    ResultWrapper.GenericError(code, errorResponse)
                }
                else -> {
                    // 不確定什麼時候會跑到這裡來
                    ResultWrapper.GenericError(null, null)
                }
            }
        }
    }
}

/**
 * 這邊的HttpException是retrofit的exception
 * 可以從這邊拿到原來的response，再進行一次轉換 轉成errorResponse
 */
private fun convertErrorBody(throwable: HttpException): ErrorResponse? {
    return try {
        throwable.response()?.errorBody()?.source()?.let {
            val moshiAdapter = Moshi.Builder().build().adapter(ErrorResponse::class.java)
            moshiAdapter.fromJson(it)
        }
    } catch (exception: Exception) {
        null
    }
}