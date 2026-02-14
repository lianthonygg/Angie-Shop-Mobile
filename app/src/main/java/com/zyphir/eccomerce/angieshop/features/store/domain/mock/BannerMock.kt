package com.zyphir.eccomerce.angieshop.features.store.domain.mock

import com.zyphir.eccomerce.angieshop.features.store.domain.model.Banner

val bannerMock = listOf(
    Banner(
        id = "1",
        slug = "tecnologia",
        imageUrl = "tecnology-banner.avif",
        category = "Tecnologia y Accesorios"
    ),
    Banner(
        id = "2",
        slug = "perfumes",
        imageUrl = "perfumes-banner.avif",
        category = "Perfumeria"
    ),
//    Banner(
//        id = "3",
//        slug = "infantil",
//        imageUrl = "",
//        category = "Infantil"
//    )
)