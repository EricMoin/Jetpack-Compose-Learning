package com.ericmoin.coincurrency.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericmoin.coincurrency.common.Constants
import com.ericmoin.coincurrency.common.Resource
import com.ericmoin.coincurrency.domain.use_cases.get_coin.GetCoinUseCase
import com.ericmoin.coincurrency.domain.use_cases.get_coins.GetCoinsUseCase
import com.ericmoin.coincurrency.presentation.coin_list.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val savedStateHandle:SavedStateHandle
    ):ViewModel(){
    private val  _state = mutableStateOf<CoinDetailState>(CoinDetailState())
    val state: State<CoinDetailState> = _state
    init{
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let{
            coinId -> getCoinById(coinId)
        }
    }
    private fun getCoinById(coinId:String) = getCoinUseCase(coinId).onEach {
        result ->
        when(result){
            is Resource.Success -> {
                _state.value = CoinDetailState( coin = result.data )
            }
            is Resource.Error -> {
                _state.value = CoinDetailState(error = result.message ?: "An unexpected error occurred.")
            }
            is Resource.Loading -> {
                _state.value = CoinDetailState(isLoading = true)
            }
        }
    }.launchIn(viewModelScope)
}