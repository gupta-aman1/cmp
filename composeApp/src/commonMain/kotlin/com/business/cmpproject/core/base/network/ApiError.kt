package com.business.cmpproject.core.network

sealed class ApiError {
    object Unauthorized : ApiError()
    object Forbidden : ApiError()
    object ServerError : ApiError()
    data class Unknown(val message: String) : ApiError()
}
