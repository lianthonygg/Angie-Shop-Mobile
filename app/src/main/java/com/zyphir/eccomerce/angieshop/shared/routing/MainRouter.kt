package com.zyphir.eccomerce.angieshop.shared.routing

sealed class MainRouter(val route: String) {
    object Details : MainRouter("details/{productId}") {
        fun createRoute(productId: String) = "details/$productId"
    }
}