package com.felipersn.clean.coin_list.presentation

import com.felipersn.clean.core.common.Exceptions
import com.felipersn.clean.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: Exceptions? = null
)
