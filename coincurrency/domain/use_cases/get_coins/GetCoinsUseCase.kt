package com.ericmoin.coincurrency.domain.use_cases.get_coins

import com.ericmoin.coincurrency.common.Resource
import com.ericmoin.coincurrency.data.remote.dto.toCoin
import com.ericmoin.coincurrency.domain.model.Coin
import com.ericmoin.coincurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try{
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }catch(e:HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        }catch(e:IOException) {//Usually happen when your internet is offline
            emit(Resource.Error("Couldn't reach internet.Check your connection."))
        }
    }
}