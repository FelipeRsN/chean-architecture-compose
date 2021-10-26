package com.felipersn.clean.navigation.navigators

import androidx.navigation.NamedNavArgument
import com.felipersn.clean.navigation.NavigationCommand

object FeatureDirections {
    val root = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "home"
    }

    val creation = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "creation"
    }
}