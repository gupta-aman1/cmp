package com.business.cmpproject.core.base.result

import com.business.cmpproject.core.network.ApiError

sealed class AppResult<out T> {
    data class Success<T>(val data: T) : AppResult<T>()
    data class Error(val error: ApiError) : AppResult<Nothing>()
}
