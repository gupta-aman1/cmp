package com.business.cmpproject.presentation.features.splash

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import androidx.compose.material3.Text
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import com.business.cmpproject.presentation.features.dashboard.DashboardScreen
import com.business.cmpproject.presentation.features.login.LoginScreen

class SplashScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = getScreenModel<SplashScreenModel>()
        val navigator = LocalNavigator.current!!

        SplashContent(viewModel) { isLoggedIn ->
            if (isLoggedIn) {
                navigator.replace(DashboardScreen())
            } else {
                navigator.replace(LoginScreen())
            }
        }
    }
}