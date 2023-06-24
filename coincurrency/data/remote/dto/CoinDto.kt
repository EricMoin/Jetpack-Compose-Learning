package com.ericmoin.coincurrency.data.remote.dto

import com.ericmoin.coincurrency.domain.model.Coin
import com.google.gson.annotations.SerializedName

/*
    Here's data transform object
 */
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
fun CoinDto.toCoin(): Coin {
    return Coin (
       id = id,
       name = name,
       isActive = isActive,
       rank = rank,
       symbol = symbol,
       type = type
    )
}