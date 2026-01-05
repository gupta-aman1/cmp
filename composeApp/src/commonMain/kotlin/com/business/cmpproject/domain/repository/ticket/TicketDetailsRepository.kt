package com.business.cmpproject.domain.repository.ticket

import com.business.cmpproject.core.network.NetworkResult
import com.business.cmpproject.data.model.response.TicketHistoryPaginationResponse

interface TicketDetailsRepository {

    suspend fun fetchTicketHistory(nextPage: Int, extraParams: Map<String, String>): NetworkResult<TicketHistoryPaginationResponse>
}