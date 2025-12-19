package com.business.cmpproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform