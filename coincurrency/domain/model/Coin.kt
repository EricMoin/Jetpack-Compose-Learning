package com.ericmoin.coincurrency.domain.model

import com.google.gson.annotations.SerializedName

data class Coin (
    val id: String,
    val name: String,
    val isActive:Boolean,
    val rank: Int,
    val symbol: String,
    val type: String
)