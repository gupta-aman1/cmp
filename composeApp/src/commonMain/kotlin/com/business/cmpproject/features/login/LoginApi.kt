package com.business.cmpproject.features.login

import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.http.ContentType
import io.ktor.http.contentType

class LoginApi(
    private val client: HttpClient
) {
    /*suspend fun login(
        email: String,
        password: String
    ) {
        client.post("https://api.example.com/login") {
            setBody(
                mapOf(
                    "email" to email,
                    "password" to password
                )
            )
        }
    }*/

    suspend fun login(request: LoginRequest) : LoginSuccess {
       return client.post("https://digilakshya.info/ssm/ApiController/loginApp") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
}