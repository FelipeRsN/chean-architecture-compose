package com.felipersn.clean.data.remote

import com.felipersn.clean.data.remote.dto.CoinDetailDto
import com.felipersn.clean.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinService {
    @GET("/v1/coins")
    suspend fun getCoinsList(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}