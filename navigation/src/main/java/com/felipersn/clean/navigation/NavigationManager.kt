package com.felipersn.clean.navigation

import kotlinx.coroutines.flow.MutableSharedFlow

class NavigationManager {
    var navigationTrigger = MutableSharedFlow<NavigationDestination>()

    suspend fun navigateTo(direction: NavigationDestination) {
        navigationTrigger.emit(direction)
    }
}