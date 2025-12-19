package com.business.cmpproject.navigation

import androidx.compose.runtime.*
import androidx.compose.material3.*
import com.business.cmpproject.features.login.LoginScreen
import com.business.cmpproject.features.dashboard.DashboardScreen
/*@Composable
fun AppNavigator(startRoute: Route = Route.Login) {
   // var currentRoute by remember { mutableStateOf<Route>(Route.Dashboard) }
    var currentRoute by remember { mutableStateOf(startRoute) }

    when (currentRoute) {
        Route.Login -> LoginScreen(
            onLoginSuccess = {
                currentRoute = Route.Dashboard
            }
        )

        Route.Dashboard -> DashboardScreen()
    }
}*/




@Composable
fun AppNavigator(
    startRoute: Route = Route.Login
) {
    val navigator = remember { AppNavigatorState(startRoute) }

    val stack by navigator.stack.collectAsState()

    when (stack.last()) {

        Route.Login -> LoginScreen(
            onLoginSuccess = {
                // 🔥 LOGIN → DASHBOARD (CLEAR STACK)
                navigator.replaceRoot(Route.Dashboard)
            }
        )

        Route.Dashboard -> DashboardScreen(
            onLogout = {
                // future use
                navigator.replaceRoot(Route.Login)
            }
        )
    }
}

