package com.zyphir.eccomerce.angieshop.features.store.domain.model

import androidx.compose.runtime.Immutable

@Immutable
sealed interface StoreUiItem {
    data class Header(val title: String) : StoreUiItem
    data class Item(val product: Product) : StoreUiItem
}