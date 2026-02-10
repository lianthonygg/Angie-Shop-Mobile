package com.zyphir.eccomerce.angieshop.shared.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zyphir.eccomerce.angieshop.shared.presentation.host.StoreNavHost
import com.zyphir.eccomerce.angieshop.shared.presentation.widgets.BottomNavigationBar
import com.zyphir.eccomerce.angieshop.shared.presentation.widgets.StoreAppBar

@Composable
fun StoreScreen(rootNavController: NavHostController) {
    val tabNavController = rememberNavController()
    val navBackStackEntry by tabNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            StoreAppBar(
                navController = tabNavController,
                route = currentRoute?.route ?: ""
            )
        },
        bottomBar = {
            BottomNavigationBar(tabNavController, currentRoute)
        }
    ) { innerPadding ->
        StoreNavHost(rootNavController, tabNavController, innerPadding)
    }
}