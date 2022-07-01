package com.felipersn.clean.navigation

import androidx.navigation.NamedNavArgument

interface NavigationCommand {
    val route: String
    val arguments: List<NamedNavArgument>
}
