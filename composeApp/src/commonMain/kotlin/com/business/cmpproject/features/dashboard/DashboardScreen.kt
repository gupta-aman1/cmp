package com.business.cmpproject.features.dashboard

import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.business.cmpproject.features.dashboard.navigation.*
import org.koin.compose.koinInject
import org.jetbrains.compose.resources.painterResource

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = koinInject(),
    onLogout: () -> Unit = {}
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        bottomBar = {
            NavigationBar {
                DashboardTab.values().forEach { tab ->
                    NavigationBarItem(
                        selected = state.selectedTab == tab,
                        onClick = {
                            viewModel.onEvent(
                                DashboardEvent.TabSelected(tab)
                            )
                        },
                        icon = {
                            Icon(
                                painter = painterResource(tab.icon),
                                contentDescription = tab.title
                            )
                        },
                        label = { Text(tab.title) }
                    )
                }
            }
        }
    ) {
        DashboardNavigator(tab = state.selectedTab)
    }
}
