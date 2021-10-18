package com.felipersn.clean.core.common

sealed class NavigationUtils(val route: String) {
    object CoinListScreen : NavigationUtils("coin_list_screen")
    object CoinDetailScreen : NavigationUtils("coin_detail_screen")
}
