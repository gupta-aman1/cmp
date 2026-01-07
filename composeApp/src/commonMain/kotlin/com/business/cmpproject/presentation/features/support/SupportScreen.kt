package com.business.cmpproject.presentation.features.support

import SupportRequest
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.business.cmpproject.core.state.UiState
import com.business.cmpproject.data.model.response.PlanResponse
import com.business.cmpproject.presentation.components.AppScaffold
import com.business.cmpproject.presentation.components.FullScreenError
import com.business.cmpproject.presentation.components.StandardTopAppBar
import com.business.cmpproject.presentation.features.invoice.InvoiceListContent
import com.business.cmpproject.presentation.features.plans.CustomerPlansScreenModel
import com.business.cmpproject.presentation.features.ticket.TicketScreenModel
import com.business.cmpproject.presentation.theme.CreamBackground
import com.business.cmpproject.presentation.theme.DarkBackground
import com.business.cmpproject.presentation.theme.DarkSurface
import com.business.cmpproject.presentation.theme.GreenPrimary
import com.business.cmpproject.presentation.theme.PinkPrimary
import kotlinx.coroutines.flow.emptyFlow

class SupportScreen: Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val isDark = isSystemInDarkTheme()
        // val rootNavigator = navigator.parent ?: navigator
        val screenModel = getScreenModel<SupportScreenModel>()
         val customerPlanScreenModel = getScreenModel<CustomerPlansScreenModel>()

        val state by screenModel.state.collectAsState()
        val uiState by customerPlanScreenModel.state.collectAsState()
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()


         when (uiState) {
            is UiState.Loading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = if (isDark) PinkPrimary else GreenPrimary)
                }
            }

            is UiState.Error -> {
                Text("Unable to load location")
            }

            is UiState.Success -> {
                val plans = (uiState as UiState.Success<List<PlanResponse>>).data
                if (plans.isEmpty()) {
                    Text("location is empty")
                } else {
                    AppScaffold(events = emptyFlow()) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(if (isDark) DarkBackground else CreamBackground)
                                .nestedScroll(scrollBehavior.nestedScrollConnection) // Connect scroll logic
                        ) {
                            // Manually adding the TopBar at the top of the column
                            StandardTopAppBar(
                                title = "Support",
                                showBack = true, // Explicitly set to true for this screen
                                onBack = {navigator.pop()},
                                scrollBehavior = scrollBehavior,
                                isTitleCenter = false,

                                )
// 1. Locations extract karein (Jo null na hon aur unique hon)

                            SupportContent(locationResp = plans)
                        }
                    }
                }
            }
            else -> Unit
        }



        }



    }


