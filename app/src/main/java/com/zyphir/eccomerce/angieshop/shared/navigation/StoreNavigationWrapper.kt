package com.zyphir.eccomerce.angieshop.shared.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.zyphir.eccomerce.angieshop.features.cart.presentation.screens.CartScreen
import com.zyphir.eccomerce.angieshop.features.profile.presentation.screens.ProfileScreen
import com.zyphir.eccomerce.angieshop.features.store.presentation.screens.StoreScreen
import com.zyphir.eccomerce.angieshop.shared.core.ex.backTo
import com.zyphir.eccomerce.angieshop.shared.core.ex.navigateTo
import com.zyphir.eccomerce.angieshop.shared.presentation.components.BottomNavigationBar

@Composable
fun StoreNavigationWrapper(navigateToDetail: (String) -> Unit) {
    val backStack = rememberNavBackStack(Routes.Store)
    val current = backStack.lastOrNull()

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.backTo(Routes.Store) },
        entryProvider = entryProvider {
            entry<Routes.Store> {
                StoreScreen(
                    navigateToDetails = { slug ->
                        navigateToDetail(slug)
                    }
                ) {
                    BottomNavigationBar(current) {
                        backStack.navigateTo(current, it)
                    }
                }
            }

            entry<Routes.Cart> {
                CartScreen {
                    BottomNavigationBar(current) {
                        backStack.navigateTo(current, it)
                    }
                }
            }

            entry<Routes.Profile> {
                ProfileScreen {
                    BottomNavigationBar(current) {
                        backStack.navigateTo(current, it)
                    }
                }
            }

            entry<Routes.Error> {
                Text("Error :(")
            }
        },
        transitionSpec = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(250)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(250)
            )
        },
        popTransitionSpec = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(250)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(250)
            )
        },
        predictivePopTransitionSpec = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(250)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(250)
            )
        }
    )
}