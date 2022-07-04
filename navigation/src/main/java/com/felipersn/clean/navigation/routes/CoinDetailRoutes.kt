package com.felipersn.clean.navigation.routes

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.felipersn.clean.navigation.NavigationCommand
import com.felipersn.clean.navigation.NavigationDestination
import com.felipersn.core.utils.Constants

object CoinDetailRoutes {
    val root = object : NavigationCommand {
        override val route = "${Routes.COIN_DETAIL.get}/{${Constants.PARAM_COIN_ID}}"
        override val arguments = listOf(
            navArgument(Constants.PARAM_COIN_ID) {
                type = NavType.StringType
            }
        )
    }

    fun root(coinId: String) = object : NavigationDestination {
        override val navigatorRoute = "${Routes.COIN_DETAIL.get}/$coinId"
    }
}