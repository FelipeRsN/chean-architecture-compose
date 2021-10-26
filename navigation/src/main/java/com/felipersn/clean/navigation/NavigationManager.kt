package com.felipersn.clean.navigation

import kotlinx.coroutines.flow.MutableSharedFlow

object NavigationManager {
    var navigationTrigger = MutableSharedFlow<String>()

    suspend fun navigateTo(directions: String) {
        navigationTrigger.emit(directions)
    }
}