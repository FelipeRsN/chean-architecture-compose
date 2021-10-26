package com.felipersn.clean.navigation

import com.felipersn.clean.navigation.navigators.FeatureDirections.root
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {
    var commands = MutableStateFlow(root)

    fun navigate(directions: NavigationCommand) {
        commands.value = directions
    }
}