package com.zyphir.eccomerce.angieshop.features.store.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zyphir.eccomerce.angieshop.features.store.domain.model.Product
import com.zyphir.eccomerce.angieshop.features.store.presentation.viewmodels.StoreViewModel
import com.zyphir.eccomerce.angieshop.shared.state.UiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun StoreView() {
    val viewModel: StoreViewModel = koinViewModel()
    val state by viewModel.products.collectAsStateWithLifecycle()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        when(state) {
            is UiState.Waiting -> {

            }

            is UiState.Loading -> {
                CircularProgressIndicator()
            }

            is UiState.Error -> {
                val message = (state as UiState.Error).message
                Text(text = message)
            }

            else -> {
                val data = (state as UiState.Done<Map<String, List<Product>>>).data

                LazyColumn(
                    modifier = Modifier.padding(innerPadding)
                ) {
                    data.forEach { (category, products) ->
                        item {
                            Text(
                                text = category,
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp)
                            )
                        }

                        items(products.chunked(2)) { row ->
                            Row(modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                row.forEach { product ->
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                    ) {
                                        ProductCard(product)
                                    }
                                }
                            }

                            //if(row.size == 1) {
                                //Spacer(modifier = Modifier.)
                            //}
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 6.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(product.name)
            Text(product.price.toString())
        }
    }
}