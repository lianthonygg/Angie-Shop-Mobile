package com.zyphir.eccomerce.angieshop.features.store.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zyphir.eccomerce.angieshop.features.store.presentation.components.StoreAppBar
import com.zyphir.eccomerce.angieshop.features.store.presentation.views.StoreView

@Composable
fun StoreScreen(navigateToDetails: (String) -> Unit, bottomBar: @Composable (() -> Unit) = {}) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { StoreAppBar() },
        bottomBar = { bottomBar() }
    ) { paddingValues ->
        StoreView(paddingValues) { navigateToDetails(it) }
    }
}