package com.business.cmpproject.features.login

import com.business.cmpproject.core.base.result.AppResult


interface LoginRepository {
    suspend fun login(
        email: String,
        password: String
    ): AppResult<LoginSuccess>
}