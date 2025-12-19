package com.business.cmpproject.features.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginSuccess(
    val status: Boolean,
    val message: String,
    val userId: String="",
    val token: String=""
)