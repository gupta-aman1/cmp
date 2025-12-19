package com.business.cmpproject.features.login

import com.business.cmpproject.core.base.result.AppResult
import com.business.cmpproject.core.network.ApiError


class LoginRepositoryImpl(
    private val api: LoginApi
) : LoginRepository {

    override suspend fun login(
        email: String,
        password: String
    ): AppResult<LoginSuccess> {
        return try {
            val dto = api.login(
                LoginRequest(email, password)
            )

            if (dto.status) {
                AppResult.Success(
                    LoginSuccess(
                        status = dto.status,
                        message = dto.message,
                        userId = dto.userId,
                        token = dto.token
                    )
                )
            } else {
                AppResult.Error(error = ApiError.Unknown(dto.message))
            }
        } catch (e: Exception) {
            AppResult.Error(error = ApiError.Unknown(e.message ?: "Login failed"))
        }
    }
    }

