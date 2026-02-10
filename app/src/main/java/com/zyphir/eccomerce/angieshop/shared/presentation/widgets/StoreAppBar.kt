package com.zyphir.eccomerce.angieshop.shared.presentation.widgets

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.zyphir.eccomerce.angieshop.shared.routing.BottomNavRouter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreAppBar(navController: NavHostController, route: String) {
    TopAppBar(
        title = { when (route) {
            BottomNavRouter.Store.route -> Text(text = "Tienda")
            BottomNavRouter.Cart.route -> Text(text = "Carrito")
            BottomNavRouter.Profile.route -> Text(text = "Perfil")
            else -> Text(text = "Tienda")
        } },
    )
}