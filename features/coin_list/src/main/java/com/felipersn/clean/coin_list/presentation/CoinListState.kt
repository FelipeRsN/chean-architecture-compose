package com.felipersn.clean.coin_list.presentation

import com.felipersn.core.utils.Exceptions
import com.felipersn.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: Exceptions? = null
)
