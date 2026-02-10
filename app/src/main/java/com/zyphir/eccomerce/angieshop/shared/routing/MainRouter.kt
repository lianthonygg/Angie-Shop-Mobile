package com.zyphir.eccomerce.angieshop.shared.routing

sealed class MainRouter(val route: String) {
    object Details : MainRouter("details/{slug}") {
        fun createRoute(slug: String) = "details/$slug"
    }
}