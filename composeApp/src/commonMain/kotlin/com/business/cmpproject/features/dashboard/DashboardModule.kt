package com.business.cmpproject.features.dashboard

import org.koin.dsl.module

val dashboardModule = module {
    factory { DashboardViewModel() }
}
