package com.zyphir.eccomerce.angieshop.features.cart.presentation.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zyphir.eccomerce.angieshop.Greeting

@Composable
fun CartView() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Carrito",
            modifier = Modifier.padding(innerPadding)
        )
    }
}