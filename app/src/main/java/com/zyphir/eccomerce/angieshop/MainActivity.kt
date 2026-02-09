package com.zyphir.eccomerce.angieshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.compose.rememberNavController
import com.zyphir.eccomerce.angieshop.shared.presentation.host.AngieShopNavHost
import com.zyphir.eccomerce.angieshop.shared.presentation.ui.theme.AngieShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AngieShopTheme {
                Surface {
                    AngieShopApp()
                }
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun AngieShopApp() {
    val navController = rememberNavController()

    AngieShopNavHost(navController)

//    val bottomBarRoutes = remember {
//        setOf(
//            BottomNavRouter.Store,
//            BottomNavRouter.Cart,
//            BottomNavRouter.Profile
//        )
//    }
//
//    val showBottomBar by remember(currentRoute) {
//        derivedStateOf { currentRoute in bottomBarRoutes.map { it.route } }
//    }
//
//    NavigationSuiteScaffold(
//        navigationSuiteItems = {
//            if(showBottomBar) {
//                bottomBarRoutes.forEach {
//                    item(
//                        icon = {
//                            Icon(
//                                it.icon,
//                                contentDescription = it.label
//                            )
//                        },
//                        label = { Text(it.label) },
//                        selected = it.route == currentRoute,
//                        onClick = { navController.navigate(it.route) }
//                    )
//                }
//            }
//        }
//    ) {
//        AngieShopNavHost(navController)
//    }
}
