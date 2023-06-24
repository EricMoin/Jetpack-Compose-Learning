package com.ericmoin.coincurrency.domain.model

import com.ericmoin.coincurrency.data.remote.dto.CoinDetailDto


data class CoinDetail(
    val coindId:String,
    val name:String,
    val description:String,
    val symbol:String,
    val rank:Int,
    val isActive:Boolean,
    val tags:List<String>,
    val team:List<CoinDetailDto.Team>
)
