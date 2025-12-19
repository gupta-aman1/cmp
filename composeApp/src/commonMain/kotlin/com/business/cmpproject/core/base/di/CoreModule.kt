package com.business.cmpproject.core.base.di

import com.business.cmpproject.core.base.dispatchers.AppDispatchers
import com.business.cmpproject.core.base.network.HttpClientFactory
import org.koin.dsl.module

val coreModule = module {
    single { HttpClientFactory.create() }

    single { AppDispatchers() }
}