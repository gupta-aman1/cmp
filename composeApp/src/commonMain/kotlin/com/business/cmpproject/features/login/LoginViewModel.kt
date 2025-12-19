package com.business.cmpproject.features.login


import com.business.cmpproject.core.base.BaseViewModel
import com.business.cmpproject.core.base.result.AppResult
import com.business.cmpproject.core.network.ApiError
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: LoginRepository
) : BaseViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged ->
                _state.update { it.copy(email = event.value) }

            is LoginEvent.PasswordChanged ->
                _state.update { it.copy(password = event.value) }

            LoginEvent.Submit -> login()
        }
    }

    private fun login() {
        scope.launch {
            _state.update {
                it.copy(
                    loading = true,
                    error = null,
                    isLoginSuccess = false
                )
            }

            when (val result =
                repository.login(
                    _state.value.email,
                    _state.value.password
                )
            ) {
                is AppResult.Success ->
                    _state.update {
                        it.copy(
                            loading = false,
                            isLoginSuccess = true,
                            successData = result.data
                        )
                    }

                /*is AppResult.Error ->
                    _state.update {
                        it.copy(
                            loading = false,
                            error = result.message,
                            isLoginSuccess = false
                        )
                    }*/

                is AppResult.Error -> {
                    val msg = when (result.error) {
                        ApiError.Unauthorized -> "Unauthorized user"
                        ApiError.Forbidden -> "Access denied"
                        ApiError.ServerError -> "Server error"
                        is ApiError.Unknown -> result.error.message
                        else -> {}
                    }

                    /*_state.update {
                        it.copy(loading = false, error = result.error.toString())
                    }*/
                }
            }
        }
    }
}
