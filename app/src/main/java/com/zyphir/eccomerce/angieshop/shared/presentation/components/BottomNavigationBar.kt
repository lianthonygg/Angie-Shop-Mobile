package com.zyphir.eccomerce.angieshop.shared.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import com.zyphir.eccomerce.angieshop.shared.navigation.Routes

@Composable
fun BottomNavigationBar(current: NavKey?, navigateTo: (NavKey) -> Unit) {

    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text("Tienda") },
            selected = current == Routes.Store,
            onClick = {
                navigateTo(Routes.Store)
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
            label = { Text("Carrito") },
            selected = current == Routes.Cart,
            onClick = {
                navigateTo(Routes.Cart)
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.AccountBox, contentDescription = null) },
            label = { Text("Perfil") },
            selected = current == Routes.Profile,
            onClick = {
                navigateTo(Routes.Profile)
            }
        )
    }
}