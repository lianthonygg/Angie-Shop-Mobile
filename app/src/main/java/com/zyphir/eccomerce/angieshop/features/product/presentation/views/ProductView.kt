package com.zyphir.eccomerce.angieshop.features.product.presentation.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zyphir.eccomerce.angieshop.features.product.domain.model.Product
import com.zyphir.eccomerce.angieshop.features.product.presentation.components.ProductAppBar
import com.zyphir.eccomerce.angieshop.features.product.presentation.components.ProductContent
import com.zyphir.eccomerce.angieshop.features.product.presentation.viewmodels.ProductViewModel
import com.zyphir.eccomerce.angieshop.shared.presentation.components.LoadingWidget
import com.zyphir.eccomerce.angieshop.shared.state.UiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductView(slug: String, navigateBack: () -> Unit) {
    val viewModel: ProductViewModel = koinViewModel()
    val state by viewModel.product.collectAsStateWithLifecycle()

    viewModel.getProduct(slug)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ProductAppBar(navigateBack) },
        content = { innerPadding ->
            when (state) {
                is UiState.Waiting -> {}
                is UiState.Loading -> LoadingWidget()
                is UiState.Error -> Text(text = (state as UiState.Error).message)
                else -> {
                    val data = (state as UiState.Done<Product>).data
                    ProductContent(innerPadding, data)
                }
            }
        }
    )
}