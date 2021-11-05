package com.felipersn.clean.navigation.routes

import androidx.navigation.NamedNavArgument
import com.felipersn.clean.navigation.NavigationCommand

object CoinListRoutes {
    val root = object : NavigationCommand {
        override val route = Routes.COIN_LIST.get
        override val arguments = emptyList<NamedNavArgument>()
    }
}