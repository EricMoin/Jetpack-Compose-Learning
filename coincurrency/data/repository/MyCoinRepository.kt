package com.ericmoin.coincurrency.data.repository

import com.ericmoin.coincurrency.data.remote.CoinPaprikaApi
import com.ericmoin.coincurrency.data.remote.dto.CoinDetailDto
import com.ericmoin.coincurrency.data.remote.dto.CoinDto
import com.ericmoin.coincurrency.domain.repository.CoinRepository
import javax.inject.Inject


class MyCoinRepository @Inject constructor( private val api:CoinPaprikaApi ):CoinRepository{
    override suspend fun getCoins() = api.getCoins()
    override suspend fun getCoinById(coinId: String) = api.getCoinById(coinId)
}