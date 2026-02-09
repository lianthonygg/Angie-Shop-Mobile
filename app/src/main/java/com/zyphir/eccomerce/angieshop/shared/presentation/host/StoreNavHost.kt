package com.zyphir.eccomerce.angieshop.shared.presentation.host

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zyphir.eccomerce.angieshop.features.cart.presentation.views.CartView
import com.zyphir.eccomerce.angieshop.features.profile.presentation.views.ProfileView
import com.zyphir.eccomerce.angieshop.features.store.presentation.views.StoreView
import com.zyphir.eccomerce.angieshop.shared.routing.BottomNavRouter
import com.zyphir.eccomerce.angieshop.shared.routing.MainRouter

@Composable
fun StoreNavHost(rootNavController: NavHostController, tabNavController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = tabNavController,
        startDestination = BottomNavRouter.Store.route,
        modifier = Modifier.padding(innerPadding),
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
            StoreView { productId ->
                rootNavController.navigate(MainRouter.Details.createRoute(productId))
            }
        }

        composable(BottomNavRouter.Cart.route) {
            CartView()
        }

        composable(BottomNavRouter.Profile.route) {
            ProfileView()
        }
    }
}