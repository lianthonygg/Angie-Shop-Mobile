package com.zyphir.eccomerce.angieshop.features.product.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zyphir.eccomerce.angieshop.features.product.domain.model.Product

@Composable
fun ProductContent(innerPadding: PaddingValues, product: Product) {
    Box(modifier = Modifier.padding(innerPadding)) {
        Text(product.name)
    }
}