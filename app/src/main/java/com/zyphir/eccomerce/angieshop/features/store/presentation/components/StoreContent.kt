package com.zyphir.eccomerce.angieshop.features.store.presentation.components

import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zyphir.eccomerce.angieshop.features.store.domain.model.StoreUiItem

@Composable
fun StoreContent(
    data: List<StoreUiItem>,
    onNavigateToDetails: (String) -> Unit
) {
    val gridState = rememberLazyGridState()

    LazyVerticalGrid(
        flingBehavior = ScrollableDefaults.flingBehavior(),
        state = gridState,
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            Banner()
        }

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