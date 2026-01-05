package com.business.cmpproject.domain.repository.ticket

import com.business.cmpproject.core.network.NetworkResult
import com.business.cmpproject.core.network.blindApiCall
import com.business.cmpproject.data.model.response.TicketHistoryPaginationResponse
import com.business.cmpproject.data.remote.TicketTrackingApi

class TicketDetailsRepositoryImpl (
    private val api: TicketTrackingApi
) : TicketDetailsRepository {
    override suspend fun fetchTicketHistory(
        nextPage: Int,
        extraParams: Map<String, String>
    ): NetworkResult<TicketHistoryPaginationResponse> {
        return blindApiCall { api.fetchTicketHistory(nextPage, extraParams) }

    }
}