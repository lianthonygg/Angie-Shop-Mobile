package com.zyphir.eccomerce.angieshop.features.cart.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zyphir.eccomerce.angieshop.features.cart.presentation.components.CartAppBar
import com.zyphir.eccomerce.angieshop.features.cart.presentation.views.CartView

@Composable
fun CartScreen(bottomBar: @Composable (() -> Unit) = {}) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { CartAppBar() },
        bottomBar = { bottomBar() }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            CartView()
        }
    }
}