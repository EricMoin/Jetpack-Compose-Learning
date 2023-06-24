package com.ericmoin.coincurrency.di

import com.ericmoin.coincurrency.common.Constants
import com.ericmoin.coincurrency.data.remote.CoinPaprikaApi
import com.ericmoin.coincurrency.data.repository.MyCoinRepository
import com.ericmoin.coincurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)//Live as long as our applications
object AppModule {
    @Provides
    @Singleton
    fun providePaprikaApi():CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }
    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi):CoinRepository{
        return MyCoinRepository(api)
    }
}