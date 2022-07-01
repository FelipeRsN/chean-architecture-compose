package com.felipersn.clean.domain.repository

import com.felipersn.clean.network.dto.CoinDetailDto
import com.felipersn.clean.network.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}