package com.felipersn.clean.data.repository

import com.felipersn.clean.data.remote.CoinService
import com.felipersn.clean.data.remote.dto.CoinDetailDto
import com.felipersn.clean.data.remote.dto.CoinDto
import com.felipersn.clean.domain.repository.CoinRepository

class CoinRepositoryImpl(private val api: CoinService): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoinsList()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}