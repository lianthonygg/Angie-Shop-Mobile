package com.zyphir.eccomerce.angieshop.features.store.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategoryHeader(title: String, modifier: Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        )
    }
}