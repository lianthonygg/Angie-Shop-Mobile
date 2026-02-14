package com.zyphir.eccomerce.angieshop.shared.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.zyphir.eccomerce.angieshop.features.product.presentation.views.ProductView
import com.zyphir.eccomerce.angieshop.shared.core.ex.back
import com.zyphir.eccomerce.angieshop.shared.core.ex.navigateTo

@Composable
fun NavigationWrapper() {
    val backStack = rememberNavBackStack(Routes.Store)
    val current = backStack.lastOrNull()

    NavDisplay(backStack = backStack, onBack = { backStack.back() }, entryProvider = entryProvider {
        entry<Routes.Store> {
            StoreNavigationWrapper(
                navigateToDetail = {
                    backStack.navigateTo(current, Routes.Product(it))
                }
            )
        }

        entry<Routes.Product> { key ->
            ProductView(key.slug) {
                backStack.back()
            }
        }

        entry<Routes.Error> {
            Text("Error :(")
        }
    })
}