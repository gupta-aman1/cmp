package com.business.cmpproject.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServiceRequestItem(
    val id: Int,
    @SerialName("location_name") val locationName: String,
    @SerialName("bandwidth_capacity") val bandwidth: String,
    @SerialName("bts_code_m6_code") val btsCode: String,
    @SerialName("mux_id") val muxId: String,
    @SerialName("bts_address") val address: String,
    @SerialName("report_type") val reportType: String,
    @SerialName("created_at") val createdAt: String,
    val note: String? = null,
    val remark: String? = null
)