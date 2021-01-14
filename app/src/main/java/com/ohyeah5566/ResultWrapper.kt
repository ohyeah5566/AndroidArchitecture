package com.ohyeah5566

/**
 *  通用型的retrofit result
 *  因為retrofit+coroutine+converter的關係在call的時候就會預期好正常的result了
 *  但有時候會因為一些問題造成result不如預期 ex, post的時候資料格式不對之類的
 *  這時候的result 通常不會返回符合預期的結果
 *  所以可以將 call Api預期的結果分成三種
 *  1是正常的result  Success,
 *  2是有問題的result GenericError,
 *  3是網路問題，這邊如果沒有要細分網路問題只要用object讓後續的處理可以知道是網路問題就好
 */
sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class GenericError(val code: Int? = null, val error: ErrorResponse? = null) :
        ResultWrapper<Nothing>()

    object NetworkError : ResultWrapper<Nothing>()
}