package com.business.cmpproject.domain.repository.support

import SupportRequest
import com.business.cmpproject.core.network.NetworkResult

interface SupportRepository {


    suspend fun submitReport(request: SupportRequest): NetworkResult<Any>
}