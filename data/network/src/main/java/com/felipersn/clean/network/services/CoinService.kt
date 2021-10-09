package com.felipersn.clean.network.services

import com.felipersn.clean.network.dto.CoinDetailDto
import com.felipersn.clean.network.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinService {
    @GET("/v1/coins")
    suspend fun getCoinsList(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}