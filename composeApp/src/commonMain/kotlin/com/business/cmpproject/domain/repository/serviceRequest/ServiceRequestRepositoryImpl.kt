package com.business.cmpproject.domain.repository.serviceRequest

import com.business.cmpproject.core.network.NetworkResult
import com.business.cmpproject.core.network.blindApiCall
import com.business.cmpproject.data.model.response.ServiceRequestPaginationResponse
import com.business.cmpproject.data.remote.PlanApi
import com.business.cmpproject.data.remote.ServiceRequestApi

class ServiceRequestRepositoryImpl(private val api: ServiceRequestApi) : ServiceRequestRepository {
    override suspend fun getServiceRequests(page: Int): NetworkResult<ServiceRequestPaginationResponse> {
       return blindApiCall { api.getServiceRequests(page) }

    }
}