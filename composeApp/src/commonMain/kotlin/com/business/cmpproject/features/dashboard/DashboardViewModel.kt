package com.business.cmpproject.features.dashboard

import com.business.cmpproject.core.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class DashboardViewModel : BaseViewModel() {

    private val _state = MutableStateFlow(DashboardState())
    val state: StateFlow<DashboardState> = _state

    fun onEvent(event: DashboardEvent) {
        when (event) {
            is DashboardEvent.TabSelected -> {
                _state.update {
                    it.copy(selectedTab = event.tab)
                }
            }
        }
    }
}