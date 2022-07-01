package com.felipersn.clean.domain.mapper

import com.felipersn.clean.domain.model.Coin
import com.felipersn.clean.domain.model.CoinDetail
import com.felipersn.clean.domain.model.TeamMember
import com.felipersn.clean.network.dto.CoinDetailDto
import com.felipersn.clean.network.dto.CoinDto
import com.felipersn.clean.network.dto.TeamMemberDto

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = this.id,
        description = this.description,
        symbol = this.symbol,
        rank = this.rank,
        isActive = this.isActive,
        name = this.name,
        team = this.team?.map { it.toTeamMember() },
        tags = this.tags?.map { it.name ?: "" }
    )
}

fun CoinDto.toCoin(): Coin = Coin(
    id = this.id,
    isActive = this.isActive,
    name = this.name,
    rank = this.rank,
    symbol = this.symbol,
)

fun TeamMemberDto.toTeamMember(): TeamMember = TeamMember(
    memberId = this.id,
    name = this.name,
    position = this.position
)
