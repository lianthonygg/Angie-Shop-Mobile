package com.zyphir.eccomerce.angieshop.features.store.presentation.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.zyphir.eccomerce.angieshop.R
import com.zyphir.eccomerce.angieshop.features.store.domain.model.Product

@Composable
fun ProductCard(product: Product, modifier: Modifier = Modifier, onToggle: () -> Unit) {

    ElevatedCard(
        modifier = modifier
        .fillMaxWidth(),
        onClick = onToggle
    ) {
        Column(
            modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
        ) {
            Box(modifier = Modifier.heightIn(max = 200.dp)) {
                AsyncImage(
                    model = "https://fanzjptylyuvwvlotopk.supabase.co/storage/v1/render/image/public/product-images/${product.imageUrl}?width=384&resize=contain&quality=80",
                    contentDescription = product.name,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = painterResource(R.drawable.ic_placeholder),
                    error = painterResource(R.drawable.ic_error),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = product.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text("$${product.price} ${product.currency}")
            }
        }
    }
}