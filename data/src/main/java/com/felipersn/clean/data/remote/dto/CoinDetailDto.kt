package com.felipersn.clean.data.remote.dto

import com.felipersn.clean.domain.model.CoinDetail
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
    val linksExtended: List<LinksExtended?>? = listOf(),
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
    val tags: List<Tag>? = listOf(),
    val team: List<TeamMember>? = listOf(),
    val type: String? = "",
    val whitepaper: Whitepaper? = Whitepaper()
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

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = this.id,
        description = this.description,
        symbol = this.symbol,
        rank = this.rank,
        isActive = this.isActive,
        name = this.name,
        team = this.team,
        tags = this.tags?.map { it.name ?: "" }
    )
}

data class LinksExtended(
    val stats: Stats? = Stats(),
    val type: String? = "",
    val url: String? = ""
)

data class Stats(
    val contributors: Int? = 0,
    val followers: Int? = 0,
    val stars: Int? = 0,
    val subscribers: Int? = 0
)

data class Tag(
    @SerializedName("coin_counter")
    val coinCounter: Int? = 0,
    @SerializedName("ico_counter")
    val icoCounter: Int? = 0,
    val id: String? = "",
    val name: String? = ""
)

data class TeamMember(
    val id: String? = "",
    val name: String? = "",
    val position: String? = ""
)

data class Whitepaper(
    val link: String? = "",
    val thumbnail: String? = ""
)