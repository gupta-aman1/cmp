package com.business.cmpproject.features.dashboard


import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse

class DashboardApi(
    private val client: HttpClient
) {
    suspend fun getDashboard(): HttpResponse {
        return client.get("https://api.example.com/dashboard")
    }
}
