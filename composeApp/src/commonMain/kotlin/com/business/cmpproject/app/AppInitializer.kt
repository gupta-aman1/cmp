package com.business.cmpproject.app

import com.business.cmpproject.core.base.di.coreModule
import com.business.cmpproject.features.dashboard.dashboardModule
import com.business.cmpproject.features.login.LoginModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            coreModule,
            LoginModule,
            dashboardModule
        )
    }
}
