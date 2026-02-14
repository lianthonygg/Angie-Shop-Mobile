package com.zyphir.eccomerce.angieshop.features.store.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zyphir.eccomerce.angieshop.features.store.domain.model.StoreUiItem
import com.zyphir.eccomerce.angieshop.features.store.presentation.viewmodels.StoreViewModel
import com.zyphir.eccomerce.angieshop.features.store.presentation.components.CategoryHeader
import com.zyphir.eccomerce.angieshop.features.store.presentation.components.ProductCard
import com.zyphir.eccomerce.angieshop.features.store.presentation.components.ProductSkeletonList
import com.zyphir.eccomerce.angieshop.shared.state.UiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun StoreView(paddingValues: PaddingValues, navigateToDetails: (String) -> Unit) {
    val viewModel: StoreViewModel = koinViewModel()
    val state by viewModel.products.collectAsStateWithLifecycle()

    when (state) {
        is UiState.Waiting -> {}
        is UiState.Loading -> ProductSkeletonList()
        is UiState.Error -> Text(text = (state as UiState.Error).message)
        else -> {
            val data = (state as UiState.Done<List<StoreUiItem>>).data
            StoreContent(modifier = Modifier.padding(paddingValues), data) { slug ->
                navigateToDetails(slug)
            }
        }
    }
}

@Composable
fun StoreContent(
    modifier: Modifier,
    data: List<StoreUiItem>,
    onNavigateToDetails: (String) -> Unit
) {
    val gridState = rememberLazyGridState()

    LazyVerticalGrid(
        state = gridState,
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = data,
            key = {
                when (it) {
                    is StoreUiItem.Header -> "header_${it.title}"
                    is StoreUiItem.Item -> it.product.id
                }
            },
            contentType = {
                when (it) {
                    is StoreUiItem.Header -> "header"
                    is StoreUiItem.Item -> "item"
                }
            },
            span = { item ->
                when (item) {
                    is StoreUiItem.Header -> GridItemSpan(maxLineSpan)
                    is StoreUiItem.Item -> GridItemSpan(1)
                }
            }
        ) { item ->
            when (item) {
                is StoreUiItem.Header -> CategoryHeader(
                    title = item.title,
                    modifier = Modifier.animateItem()
                )

                is StoreUiItem.Item -> ProductCard(
                    product = item.product,
                    modifier = Modifier.animateItem()
                ) {
                    onNavigateToDetails(item.product.slug)
                }
            }
        }
    }
}