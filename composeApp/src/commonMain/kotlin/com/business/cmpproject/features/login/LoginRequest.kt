package com.business.cmpproject.features.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val name: String,
    val pass: String
)