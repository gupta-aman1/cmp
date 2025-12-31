package com.business.cmpproject.presentation.features.splash

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

@Composable
fun SplashContent(
    viewModel: SplashScreenModel,
    onResult: (Boolean) -> Unit
) {
    LaunchedEffect(Unit) {
        delay(2000)
        onResult(viewModel.isLoggedIn())
    }

    Text("Splash Screen")
}