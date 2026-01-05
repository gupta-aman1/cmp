package com.business.cmpproject.presentation.features.ticket

import cafe.adriel.voyager.core.model.screenModelScope
import com.business.cmpproject.core.BaseScreenModel
import com.business.cmpproject.core.network.NetworkResult
import com.business.cmpproject.core.state.UiEvent
import com.business.cmpproject.core.state.UiState
import com.business.cmpproject.core.storage.LocalStorage
import com.business.cmpproject.data.model.response.PlanResponse
import com.business.cmpproject.data.model.response.Ticket
import com.business.cmpproject.data.model.response.TicketData
import com.business.cmpproject.domain.repository.AuthRepository
import com.business.cmpproject.domain.repository.ticket.TicketRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TicketScreenModel(private val repo: TicketRepository,
                        private val storage: LocalStorage): BaseScreenModel() {


    private val _state = MutableStateFlow<UiState<List<TicketData>>>(UiState.Loading)
    val state: StateFlow<UiState<List<TicketData>>> = _state


    init {
        loadTicketHistory()

    }

    fun loadTicketHistory() {

        screenModelScope.launch {
            _state.value = UiState.Loading
            try {
                when (val result = repo.getTicketList()) {
                    is NetworkResult.Success -> {
                        //sendEvent(UiEvent.ShowSnackBar(result.data, false))
                        _state.value = UiState.Success(result.data.data)
                    }

                    is NetworkResult.Failure -> {
                        _state.value = UiState.Error(result.error.message)
                        sendEvent(
                            UiEvent.ShowSnackBar(
                                message = result.error.message,
                                isError = true
                            )
                        )
                    }
                }
            }
            catch (e: Exception) {
                _state.value = UiState.Error(e.message ?: "Unknown Connection Error")
            }
        }
    }
}