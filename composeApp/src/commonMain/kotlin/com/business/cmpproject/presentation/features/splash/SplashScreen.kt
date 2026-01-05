package com.business.cmpproject.presentation.features.splash

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import com.business.cmpproject.presentation.features.ProfileScreen
import com.business.cmpproject.presentation.features.dashboard.DashboardScreen
import com.business.cmpproject.presentation.features.home.HomeScreen
import com.business.cmpproject.presentation.features.login.LoginScreen
import com.business.cmpproject.presentation.features.plans.CustomerPlansScreen
import com.business.cmpproject.presentation.features.ticket.TicketHistoryScreen

class SplashScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = getScreenModel<SplashScreenModel>()
        val navigator = LocalNavigator.current!!

        SplashContent(viewModel) { isLoggedIn ->
            if (isLoggedIn) {
                navigator.push(TicketHistoryScreen())
              //  navigator.replace(DashboardScreen())
            } else {
                navigator.replace(LoginScreen())
            }
        }
    }
}