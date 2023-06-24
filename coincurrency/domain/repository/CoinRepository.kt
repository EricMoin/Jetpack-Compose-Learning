package com.ericmoin.coincurrency.domain.repository

import com.ericmoin.coincurrency.data.remote.dto.CoinDetailDto
import com.ericmoin.coincurrency.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(coinId:String):CoinDetailDto
}