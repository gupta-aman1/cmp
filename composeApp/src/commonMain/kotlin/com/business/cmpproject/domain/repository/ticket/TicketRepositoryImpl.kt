package com.business.cmpproject.domain.repository.ticket

import com.business.cmpproject.core.network.NetworkResult
import com.business.cmpproject.core.network.blindApiCall
import com.business.cmpproject.data.model.request.LoginRequest
import com.business.cmpproject.data.model.response.LoginResponse
import com.business.cmpproject.data.model.response.Ticket
import com.business.cmpproject.data.remote.TicketApi

class TicketRepositoryImpl(
    private val api: TicketApi
) : TicketRepository {


    override suspend fun getTicketList(): NetworkResult<List<Ticket>> {
        return blindApiCall { api.fetchTicketListFromApi() }
    }

}