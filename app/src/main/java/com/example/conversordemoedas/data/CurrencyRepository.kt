package com.example.conversordemoedas.data

import com.example.conversordemoedas.data.remote.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CurrencyRepository {

    private val api = Retrofit.Builder()
        .baseUrl("https://api.frankfurter.dev/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    suspend fun getCurrencies() = api.getCurrencies()

    suspend fun convert(amount: Double, from: String, to: String) =
        api.convertCurrency(amount, from, to)
}