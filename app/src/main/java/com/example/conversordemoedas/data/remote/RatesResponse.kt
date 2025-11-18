package com.example.conversordemoedas.data.remote

data class RatesResponse(
    val amount: Double,
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)