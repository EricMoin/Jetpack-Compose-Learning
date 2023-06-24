package com.ericmoin.coincurrency.presentation.coin_list

import com.ericmoin.coincurrency.domain.model.Coin

data class CoinListState(
    val isLoading:Boolean = false,
    val coins:List<Coin> = emptyList(),
    val error:String = ""
)

