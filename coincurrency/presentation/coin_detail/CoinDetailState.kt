package com.ericmoin.coincurrency.presentation.coin_detail

import com.ericmoin.coincurrency.domain.model.Coin
import com.ericmoin.coincurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean = false,
    val coin:CoinDetail? = null,
    val error:String = ""
)

