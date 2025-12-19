package com.business.cmpproject.features.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val error: String? = null,
    val isLoginSuccess: Boolean = false  , // ✅ ADD
    val successData: LoginSuccess? = null
)