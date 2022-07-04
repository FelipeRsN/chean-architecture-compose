package com.felipersn.clean.repository.repositories

import com.felipersn.clean.network.dto.CoinDetailDto
import com.felipersn.clean.network.dto.CoinDto
import com.felipersn.clean.network.services.CoinService
import com.felipersn.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinService) :
    CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoinsList()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}