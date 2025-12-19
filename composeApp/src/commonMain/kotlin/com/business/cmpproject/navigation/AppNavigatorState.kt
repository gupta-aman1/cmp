package com.business.cmpproject.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AppNavigatorState(
    startRoute: Route = Route.Login
) {

    private val _stack =
        MutableStateFlow<List<Route>>(listOf(startRoute))

    val stack: StateFlow<List<Route>> = _stack

    val current: Route
        get() = _stack.value.last()

    /** Normal navigation */
    fun push(route: Route) {
        _stack.value = _stack.value + route
    }

    /** Back navigation */
    fun pop() {
        if (_stack.value.size > 1) {
            _stack.value = _stack.value.dropLast(1)
        }
    }

    /** 🔥 ENTERPRISE: clear backstack (popInclusive) */

    /** replaceRoot() = Login flow destroy + Dashboard root*/

    fun replaceRoot(route: Route) {
        _stack.value = listOf(route)
    }
}
