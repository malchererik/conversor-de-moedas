package com.example.conversordemoedas.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("currencies")
    suspend fun getCurrencies(): Map<String, String>

    @GET("latest")
    suspend fun convertCurrency(
        @Query("amount") amount: Double,
        @Query("from") from: String,
        @Query("to") to: String
    ): RatesResponse
}