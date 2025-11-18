package com.example.conversordemoedas.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.conversordemoedas.ui.MainViewModel
import com.example.conversordemoedas.ui.components.DropdownMenuCurrency

@Composable
fun HomeScreen(vm: MainViewModel) {

    val currencies by vm.currencies.collectAsState()
    val result by vm.result.collectAsState()

    var amount by remember { mutableStateOf("") }
    var fromCurrency by remember { mutableStateOf("") }
    var toCurrency by remember { mutableStateOf("") }

    LaunchedEffect(true) {
        vm.loadCurrencies()
    }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Conversor de Moedas", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        // Valor
        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Valor") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        // Seleção de moedas (simples)
        DropdownMenuCurrency(
            label = "Moeda de origem",
            selected = fromCurrency,
            items = currencies.keys.toList(),
            onSelect = { fromCurrency = it }
        )

        Spacer(Modifier.height(16.dp))

        DropdownMenuCurrency(
            label = "Moeda de destino",
            selected = toCurrency,
            items = currencies.keys.toList(),
            onSelect = { toCurrency = it }
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                if (amount.isNotEmpty() && fromCurrency.isNotEmpty() && toCurrency.isNotEmpty()) {
                    vm.convert(amount.toDouble(), fromCurrency, toCurrency)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Converter")
        }

        Spacer(Modifier.height(24.dp))

        result?.let {
            Text("Resultado: $it $toCurrency", style = MaterialTheme.typography.headlineSmall)
        }
    }
}