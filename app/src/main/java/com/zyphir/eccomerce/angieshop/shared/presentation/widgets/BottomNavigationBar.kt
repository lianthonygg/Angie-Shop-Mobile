package com.zyphir.eccomerce.angieshop.shared.presentation.widgets

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.zyphir.eccomerce.angieshop.shared.routing.BottomNavRouter

@Composable
fun BottomNavigationBar(navController: NavHostController, currentDestination: NavDestination?) {
    val bottomBarRoutes = listOf(
        BottomNavRouter.Store,
        BottomNavRouter.Cart,
        BottomNavRouter.Profile
    )

    NavigationBar {
        bottomBarRoutes.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.label) },
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}