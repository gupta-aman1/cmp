package com.business.cmpproject.core.validation


object Validator {

    fun mobile(value: String): String? =
        if (value.length != 10) "Enter valid mobile number" else null

    fun password(value: String): String? =
        if (value.length < 6) "Password must be 6+ characters" else null
}