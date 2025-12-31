package com.business.cmpproject.presentation.features.login


import cafe.adriel.voyager.core.model.ScreenModel
import com.business.cmpproject.core.network.NetworkResult
import com.business.cmpproject.core.session.SessionManager
import com.business.cmpproject.core.state.UiState
import com.business.cmpproject.core.storage.LocalStorage
import com.business.cmpproject.data.model.request.LoginRequest
import com.business.cmpproject.domain.repository.AuthRepository
import kotlinx.coroutines.flow.*

class LoginScreenModel(
    private val repo: AuthRepository,
    private val storage: LocalStorage,
    private val sessionManager: SessionManager
) : ScreenModel{

    private val _state = MutableStateFlow<UiState<Unit>>(UiState.Idle)
    val state: StateFlow<UiState<Unit>> = _state

    suspend fun login(mobile: String, password: String) {
        _state.value = UiState.Loading

        when (val result = repo.login(LoginRequest(mobile, password))) {

            is NetworkResult.Success -> {
                storage.saveToken(result.data.token)
                _state.value = UiState.Success(Unit)
            }

            is NetworkResult.Failure -> {
                sessionManager.handle(result.error)
                _state.value = UiState.Error(result.error.message)
            }

            else -> {}
        }
    }
}