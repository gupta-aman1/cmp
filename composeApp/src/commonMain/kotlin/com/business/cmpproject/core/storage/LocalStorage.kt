package com.business.cmpproject.core.storage

import com.russhwolf.settings.Settings

class LocalStorage {

    private val settings = Settings()

    fun saveToken(token: String) {
        settings.putString("token", token)
    }

    fun getToken(): String? {
        return settings.getStringOrNull("token")
    }

    fun clear() {
        settings.clear()
    }
}