package com.zyphir.eccomerce.angieshop.features.store.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.zyphir.eccomerce.angieshop.R
import com.zyphir.eccomerce.angieshop.features.store.domain.mock.bannerMock

@Composable
fun Banner() {
    val pagerState = rememberPagerState(pageCount = { bannerMock.size })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
    ) { page ->
        Box(modifier = Modifier.height(200.dp).padding(horizontal = 8.dp)) {
            AsyncImage(
                model = "https://fanzjptylyuvwvlotopk.supabase.co/storage/v1/render/image/public/product-images/${bannerMock[page].imageUrl}?width=768&resize=contain&quality=85",
                contentDescription = bannerMock[page].category,
                modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(12.dp)).clipToBounds(),
                placeholder = painterResource(R.drawable.ic_placeholder),
                error = painterResource(R.drawable.ic_error),
                contentScale = ContentScale.Crop
            )
        }
    }
}