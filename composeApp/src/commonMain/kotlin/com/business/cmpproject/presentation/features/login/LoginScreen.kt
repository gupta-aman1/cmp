package com.business.cmpproject.presentation.features.login


import androidx.compose.material3.*
import androidx.compose.runtime.*
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import com.business.cmpproject.presentation.features.dashboard.DashboardScreen

class LoginScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = getScreenModel<LoginScreenModel>()
        val navigator = LocalNavigator.current!!

        LoginContent(viewModel) {
            navigator.replace(DashboardScreen())
        }
    }
}