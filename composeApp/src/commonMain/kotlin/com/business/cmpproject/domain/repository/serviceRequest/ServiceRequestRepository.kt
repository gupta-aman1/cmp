package com.business.cmpproject.domain.repository.serviceRequest

import com.business.cmpproject.core.network.NetworkResult
import com.business.cmpproject.data.model.response.ServiceRequestPaginationResponse
import io.ktor.http.parameters

interface ServiceRequestRepository {
    suspend fun getServiceRequests(page: Int): NetworkResult<ServiceRequestPaginationResponse>

}