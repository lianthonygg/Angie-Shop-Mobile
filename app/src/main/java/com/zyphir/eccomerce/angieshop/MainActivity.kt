package com.zyphir.eccomerce.angieshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.zyphir.eccomerce.angieshop.features.cart.presentation.views.CartView
import com.zyphir.eccomerce.angieshop.features.profile.presentation.views.ProfileView
import com.zyphir.eccomerce.angieshop.features.store.presentation.views.StoreView
import com.zyphir.eccomerce.angieshop.ui.theme.AngieShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AngieShopTheme {
                AngieShopApp()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun AngieShopApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.STORE) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        when (currentDestination) {
            AppDestinations.STORE -> StoreView()
            AppDestinations.CART -> CartView()
            AppDestinations.PROFILE -> ProfileView()
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    STORE("Tienda", Icons.Default.Home),
    CART("Carrito", Icons.Default.ShoppingCart),
    PROFILE("Perfil", Icons.Default.AccountBox),
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}