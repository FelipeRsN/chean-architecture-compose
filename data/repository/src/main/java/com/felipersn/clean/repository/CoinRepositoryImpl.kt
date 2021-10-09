package com.felipersn.clean.repository

import com.felipersn.clean.domain.repository.CoinRepository
import com.felipersn.clean.network.dto.CoinDetailDto
import com.felipersn.clean.network.dto.CoinDto
import com.felipersn.clean.network.services.CoinService

class CoinRepositoryImpl(private val api: CoinService) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoinsList()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}