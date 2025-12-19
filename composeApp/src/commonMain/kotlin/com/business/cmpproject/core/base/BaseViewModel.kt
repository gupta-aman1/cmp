package com.business.cmpproject.core.base

import kotlinx.coroutines.*

import kotlinx.coroutines.*

abstract class BaseViewModel(
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) {
    protected val scope =
        CoroutineScope(SupervisorJob() + dispatcher)

    open fun onCleared() {
        scope.cancel()
    }
}