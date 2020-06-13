package com.cs.lib_net.net

import com.cs.lib_net.exception.DealException

import com.cs.lib_net.exception.ResultException
import com.cs.lib_net.model.BaseModel
import com.cs.lib_net.model.BaseTXApiModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import com.cs.lib_net.model.NetResult

open class BaseRepository {

    suspend fun <T : Any> callRequest(
        call: suspend () -> NetResult<T>
    ): NetResult<T> {
        return try {
            call()
        } catch (e: Exception) {
            //这里统一处理异常
            e.printStackTrace()
            NetResult.Error(DealException.handlerException(e))
        }
    }

    suspend fun <T : Any> handleResponse(
        response: BaseModel<T>,
        successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): NetResult<T> {
        return coroutineScope {
            if (response.errorCode == -1) {
                errorBlock?.let { it() }
                NetResult.Error(
                    ResultException(
                        response.errorCode.toString(),
                        response.errorMsg
                    )
                )
            } else {
                successBlock?.let { it() }
                NetResult.Success(response.data)
            }
        }
    }

    suspend fun <T : Any> handleTXApiResponse(
        response: BaseTXApiModel<T>,
        successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): NetResult<T> {
        return coroutineScope {
            if (response.code != 200) {
                errorBlock?.let { it() }
                NetResult.Error(
                    ResultException(
                        response.code.toString(),
                        response.msg
                    )
                )
            } else {
                successBlock?.let { it() }
                NetResult.Success(response.newslist)
            }
        }
    }


}