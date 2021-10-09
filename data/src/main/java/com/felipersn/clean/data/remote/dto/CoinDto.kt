package com.felipersn.clean.data.remote.dto


import com.felipersn.clean.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin(): Coin = Coin(
    id = this.id,
    isActive = this.isActive,
    name = this.name,
    rank = this.rank,
    symbol = this.symbol,
)