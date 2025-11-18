package com.example.conversordemoedas.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conversordemoedas.data.CurrencyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repo = CurrencyRepository()

    private val _currencies = MutableStateFlow<Map<String, String>>(emptyMap())
    val currencies: StateFlow<Map<String, String>> = _currencies

    private val _result = MutableStateFlow<Double?>(null)
    val result: StateFlow<Double?> = _result

    fun loadCurrencies() {
        viewModelScope.launch {
            _currencies.value = repo.getCurrencies()
        }
    }

    fun convert(amount: Double, from: String, to: String) {
        viewModelScope.launch {
            val response = repo.convert(amount, from, to)
            _result.value = response.rates[to]
        }
    }
}