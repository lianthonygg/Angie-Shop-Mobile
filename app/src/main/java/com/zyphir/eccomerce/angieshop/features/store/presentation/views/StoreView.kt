package com.zyphir.eccomerce.angieshop.features.store.presentation.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zyphir.eccomerce.angieshop.features.store.domain.model.StoreUiItem
import com.zyphir.eccomerce.angieshop.features.store.presentation.components.ProductSkeletonList
import com.zyphir.eccomerce.angieshop.features.store.presentation.components.StoreContent
import com.zyphir.eccomerce.angieshop.features.store.presentation.viewmodels.StoreViewModel
import com.zyphir.eccomerce.angieshop.shared.state.UiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun StoreView(paddingValues: PaddingValues, navigateToDetails: (String) -> Unit) {
    val viewModel: StoreViewModel = koinViewModel()
    val state by viewModel.products.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        when (state) {
            is UiState.Waiting -> {}
            is UiState.Loading -> ProductSkeletonList()
            is UiState.Error -> Text(text = (state as UiState.Error).message)
            else -> {
                val data = (state as UiState.Done<List<StoreUiItem>>).data
                StoreContent(data) { slug ->
                    navigateToDetails(slug)
                }
            }
        }
    }
}