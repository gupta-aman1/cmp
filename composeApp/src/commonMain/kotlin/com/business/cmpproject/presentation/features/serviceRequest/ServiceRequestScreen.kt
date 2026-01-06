package com.business.cmpproject.presentation.features.serviceRequest

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.business.cmpproject.core.state.UiState
import com.business.cmpproject.presentation.components.AppScaffold
import com.business.cmpproject.presentation.components.StandardTopAppBar
import com.business.cmpproject.presentation.theme.CreamBackground
import com.business.cmpproject.presentation.theme.DarkBackground
import com.business.cmpproject.presentation.theme.GreenPrimary
import com.business.cmpproject.presentation.theme.PinkPrimary

class ServiceRequestScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<ServiceRequestScreenModel>()
        val uiState by screenModel.state.collectAsState()
        val isDark = isSystemInDarkTheme()

        AppScaffold(events = screenModel.events) {
            ServiceRequestContent(
                uiState = uiState,
                isDark = isDark,
                canLoadMore = screenModel.canLoadMore,
                onBack = { navigator.pop() },
                onLoadMore = { screenModel.loadMore() },
                onNewRequest = { /* navigator.push(RaiseRequestScreen()) */ }
            )
        }
    }
}