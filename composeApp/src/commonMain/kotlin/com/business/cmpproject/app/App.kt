package com.business.cmpproject.app

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.business.cmpproject.presentation.features.splash.SplashScreen
import com.business.cmpproject.presentation.theme.AppTheme


@Composable
fun App() {
    AppTheme {
        Navigator(SplashScreen())
    }
}
