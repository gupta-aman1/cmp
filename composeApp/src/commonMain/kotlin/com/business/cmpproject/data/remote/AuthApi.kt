package com.business.cmpproject.data.remote

import com.business.cmpproject.core.network.ApiResponse
import com.business.cmpproject.data.model.request.LoginRequest
import com.business.cmpproject.data.model.response.LoginResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.*

class AuthApi(
    private val client: HttpClient
) {
    suspend fun login(request: LoginRequest): HttpResponse {
        return client.post("/api/customer/signin") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }
    }
}