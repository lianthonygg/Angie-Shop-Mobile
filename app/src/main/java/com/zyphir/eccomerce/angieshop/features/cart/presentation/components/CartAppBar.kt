package com.zyphir.eccomerce.angieshop.features.cart.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartAppBar() {
    TopAppBar(
        title = { Text(text = "Carrito") },
    )
}