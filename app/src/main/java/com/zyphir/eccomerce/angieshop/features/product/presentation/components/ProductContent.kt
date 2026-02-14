package com.zyphir.eccomerce.angieshop.features.product.presentation.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.zyphir.eccomerce.angieshop.R
import com.zyphir.eccomerce.angieshop.features.product.domain.model.Product

@Composable
fun ProductContent(innerPadding: PaddingValues, product: Product) {
    val context = LocalContext.current
    val pagerState = rememberPagerState(pageCount = { product.productImages.size })

    fun onClick() {
        Toast.makeText(context, "Esto es pa agregarlo pero no hace na", Toast.LENGTH_SHORT).show()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
            ) { page ->
                Box(modifier = Modifier.height(400.dp).padding(horizontal = 8.dp)) {
                    AsyncImage(
                        model = "https://fanzjptylyuvwvlotopk.supabase.co/storage/v1/render/image/public/product-images/${product.productImages[page].imageUrl}?width=384&resize=contain&quality=80",
                        contentDescription = product.name,
                        modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(12.dp)).clipToBounds(),
                        placeholder = painterResource(R.drawable.ic_placeholder),
                        error = painterResource(R.drawable.ic_error),
                        contentScale = ContentScale.Crop
                    )
                }
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

            Text(
                text = product.description
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter)
                .padding(horizontal = 8.dp)
                .clip(RoundedCornerShape(16.dp)),
            onClick = { onClick() },
            content = {
                Text("Arregar al Carrito")
            }
        )
    }
}