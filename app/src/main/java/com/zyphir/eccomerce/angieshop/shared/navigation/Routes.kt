package com.zyphir.eccomerce.angieshop.shared.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes: NavKey {

    @Serializable
    data object Store: Routes()

    @Serializable
    data object Cart: Routes()

    @Serializable
    data object Profile: Routes()

    @Serializable
    data class Product(val slug: String): Routes()

    @Serializable
    data object Error: Routes()
}