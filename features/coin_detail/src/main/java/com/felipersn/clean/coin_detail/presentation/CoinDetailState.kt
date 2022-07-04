package com.felipersn.clean.coin_detail.presentation

import com.felipersn.core.utils.Exceptions
import com.felipersn.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: Exceptions? = null
)
