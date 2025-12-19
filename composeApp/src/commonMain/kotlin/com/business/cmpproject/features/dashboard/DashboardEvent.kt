package com.business.cmpproject.features.dashboard

import com.business.cmpproject.features.dashboard.navigation.DashboardTab

sealed class DashboardEvent {
    data class TabSelected(val tab: DashboardTab) : DashboardEvent()
}
