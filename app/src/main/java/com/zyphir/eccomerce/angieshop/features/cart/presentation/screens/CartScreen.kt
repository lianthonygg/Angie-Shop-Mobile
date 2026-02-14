package com.zyphir.eccomerce.angieshop.features.cart.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zyphir.eccomerce.angieshop.features.cart.presentation.views.CartView

@Composable
fun CartScreen(bottomBar: @Composable (() -> Unit) = {}) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
//            StoreAppBar(
//                navController = tabNavController,
//                route = currentRoute?.route ?: ""
//            )
        },
        bottomBar = {
            bottomBar()
        }
    ) { paddingValues ->
        CartView()
    }
}