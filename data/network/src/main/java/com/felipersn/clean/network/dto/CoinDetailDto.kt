package com.felipersn.clean.network.dto

import com.felipersn.domain.model.CoinDetail
import com.felipersn.domain.model.TeamMember
import com.google.gson.annotations.SerializedName

data class CoinDetailDto(
    val description: String? = "",
    @SerializedName("development_status")
    val developmentStatus: String? = "",
    @SerializedName("first_data_at")
    val firstDataAt: String? = "",
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean? = false,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String? = "",
    val id: String? = "",
    @SerializedName("is_active")
    val isActive: Boolean? = false,
    @SerializedName("is_new")
    val isNew: Boolean? = false,
    @SerializedName("last_data_at")
    val lastDataAt: String? = "",
    val links: Links? = Links(),
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtendedDto?>? = listOf(),
    val message: String? = "",
    val name: String? = "",
    @SerializedName("open_source")
    val openSource: Boolean? = false,
    @SerializedName("org_structure")
    val orgStructure: String? = "",
    @SerializedName("proof_type")
    val proofType: String? = "",
    val rank: Int? = 0,
    @SerializedName("started_at")
    val startedAt: String? = "",
    val symbol: String? = "",
    val tags: List<TagDto>? = listOf(),
    val team: List<TeamMemberDto>? = listOf(),
    val type: String? = "",
    val whitepaper: WhitepaperDto? = WhitepaperDto()
)

data class Links(
    val explorer: List<String?>? = listOf(),
    val facebook: List<String?>? = listOf(),
    val reddit: List<String?>? = listOf(),
    @SerializedName("source_code")
    val sourceCode: List<String?>? = listOf(),
    val website: List<String?>? = listOf(),
    val youtube: List<String?>? = listOf()
)

data class TeamMemberDto(
    val id: String? = "",
    val name: String? = "",
    val position: String? = ""
)

data class LinksExtendedDto(
    val stats: StatsDto? = StatsDto(),
    val type: String? = "",
    val url: String? = ""
)

data class StatsDto(
    val contributors: Int? = 0,
    val followers: Int? = 0,
    val stars: Int? = 0,
    val subscribers: Int? = 0
)

data class TagDto(
    @SerializedName("coin_counter")
    val coinCounter: Int? = 0,
    @SerializedName("ico_counter")
    val icoCounter: Int? = 0,
    val id: String? = "",
    val name: String? = ""
)

data class WhitepaperDto(
    val link: String? = "",
    val thumbnail: String? = ""
)

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

fun TeamMemberDto.toTeamMember(): TeamMember = TeamMember(
    memberId = this.id,
    name = this.name,
    position = this.position
)