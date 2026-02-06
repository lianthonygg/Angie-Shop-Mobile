package com.zyphir.eccomerce.angieshop.features.store.presentation.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zyphir.eccomerce.angieshop.Greeting
import com.zyphir.eccomerce.angieshop.features.store.presentation.viewmodels.StoreViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun StoreView() {
    val viewModel: StoreViewModel = koinViewModel()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Store",
            modifier = Modifier.padding(innerPadding)
        )
    }
}