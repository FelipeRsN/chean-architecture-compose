package com.felipersn.clean.domain.repository

import com.felipersn.clean.data.remote.dto.CoinDetailDto
import com.felipersn.clean.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}