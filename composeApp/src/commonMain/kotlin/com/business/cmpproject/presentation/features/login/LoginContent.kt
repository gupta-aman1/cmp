package com.business.cmpproject.presentation.features.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.business.cmpproject.core.state.UiState
import com.business.cmpproject.core.validation.Validator
import com.business.cmpproject.presentation.components.AppButton
import com.business.cmpproject.presentation.components.AppTextField
import com.business.cmpproject.presentation.components.PasswordField
import kotlinx.coroutines.launch

@Composable
fun LoginContent(
    viewModel: LoginScreenModel,
    onLoginSuccess: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.state.collectAsState()

    var mobile by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

    Column {

        AppTextField(mobile, { mobile = it }, "Mobile")
        PasswordField(password, { password = it }, "Password")

        AppButton(
            text = "Login",
            loading = state is UiState.Loading
        ) {
            error =
                Validator.mobile(mobile)
                    ?: Validator.password(password)

            if (error == null) {
                scope.launch {
                    viewModel.login(mobile, password)
                }
            }
        }

        error?.let {
            Text(it, color = MaterialTheme.colorScheme.error)
        }

        when (state) {
            is UiState.Success -> onLoginSuccess()
            is UiState.Error -> Text(
                (state as UiState.Error).message,
                color = MaterialTheme.colorScheme.error
            )
            else -> {}
        }
    }
}