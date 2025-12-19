package com.business.cmpproject.features.dashboard

import com.business.cmpproject.features.dashboard.navigation.DashboardTab

data class DashboardState(
    val selectedTab: DashboardTab = DashboardTab.HOME
)