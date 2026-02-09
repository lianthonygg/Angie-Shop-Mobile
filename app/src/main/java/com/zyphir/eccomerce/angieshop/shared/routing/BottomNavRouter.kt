package com.zyphir.eccomerce.angieshop.shared.routing

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavRouter(val route: String, val icon: ImageVector, val label: String) {
    object Store : BottomNavRouter("store", Icons.Default.Home, "Tienda")
    object Cart : BottomNavRouter("cart", Icons.Default.ShoppingCart, "Carrito")
    object Profile : BottomNavRouter("profile", Icons.Default.AccountBox, "Perfil")
}