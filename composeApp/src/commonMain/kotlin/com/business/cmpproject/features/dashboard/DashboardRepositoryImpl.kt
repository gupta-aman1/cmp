package com.business.cmpproject.features.dashboard

import DashboardRepository
import com.business.cmpproject.core.base.result.AppResult
import com.business.cmpproject.core.network.ApiError
import io.ktor.client.statement.HttpResponse

class DashboardRepositoryImpl(
    private val api: DashboardApi
) : DashboardRepository {

    override suspend fun loadDashboard(): AppResult<HttpResponse> =
        try {
            AppResult.Success(api.getDashboard())
        } catch (e: Exception) {
            AppResult.Error(ApiError.Unknown(e.message ?: "Unknown error"))
        }
}
