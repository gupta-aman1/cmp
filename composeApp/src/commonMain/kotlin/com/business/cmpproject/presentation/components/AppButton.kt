package com.business.cmpproject.presentation.components

import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun AppButton(
    text: String,
    loading: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        enabled = !loading
    ) {
        Text(if (loading) "Please wait..." else text)
    }
}