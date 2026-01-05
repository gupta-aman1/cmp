package com.business.cmpproject.domain.repository.ticket

import com.business.cmpproject.core.network.NetworkResult
import com.business.cmpproject.data.model.request.LoginRequest
import com.business.cmpproject.data.model.response.LoginResponse
import com.business.cmpproject.data.model.response.PlanResponse
import com.business.cmpproject.data.model.response.Ticket
import com.business.cmpproject.data.model.response.TicketData
import com.business.cmpproject.data.model.response.TicketPage

interface TicketRepository {


    suspend fun getTicketList(page: Int): NetworkResult<TicketPage>

   /* suspend fun sendOtp(
        mobile: String
    ): NetworkResult<String>*/



    }