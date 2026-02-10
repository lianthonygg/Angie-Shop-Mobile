package com.zyphir.eccomerce.angieshop.shared.presentation.host

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.zyphir.eccomerce.angieshop.features.product.presentation.views.ProductView
import com.zyphir.eccomerce.angieshop.shared.presentation.screens.StoreScreen
import com.zyphir.eccomerce.angieshop.shared.routing.BottomNavRouter
import com.zyphir.eccomerce.angieshop.shared.routing.MainRouter

@Composable
fun AngieShopNavHost(navController: NavHostController) {
    NavHost(
        navController,
        startDestination = BottomNavRouter.Store.route,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(400)
            ) + fadeIn(animationSpec = tween(400))
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(400)
            ) + fadeOut(animationSpec = tween(400))
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(400)
            ) + fadeIn(animationSpec = tween(400))
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(400)
            ) + fadeOut(animationSpec = tween(400))
        }
    ) {
        composable(BottomNavRouter.Store.route) {
            StoreScreen(navController)
        }
        composable(
            route = MainRouter.Details.route,
            arguments = listOf(navArgument("slug") { type = NavType.StringType })
        ) { backStackEntry ->
            val slug = backStackEntry.arguments?.getString("slug") ?: "Unknown"
            ProductView(navController, slug)
        }
    }
}