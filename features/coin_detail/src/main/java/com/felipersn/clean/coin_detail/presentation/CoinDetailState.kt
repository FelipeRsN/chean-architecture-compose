package com.felipersn.clean.coin_detail.presentation

import com.felipersn.clean.core.common.Exceptions
import com.felipersn.clean.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: Exceptions? = null
)
