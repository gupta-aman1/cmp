package com.business.cmpproject.app
import androidx.compose.runtime.Composable
import com.business.cmpproject.features.login.LoginScreen
import com.business.cmpproject.navigation.AppNavigator
import com.business.cmpproject.navigation.Route


@Composable
fun App() {
    //LoginScreen()
    AppNavigator(startRoute = Route.Login)
}
