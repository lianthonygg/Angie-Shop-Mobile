package com.zyphir.eccomerce.angieshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.zyphir.eccomerce.angieshop.shared.navigation.NavigationWrapper
import com.zyphir.eccomerce.angieshop.shared.presentation.ui.theme.AngieShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AngieShopTheme {
                Surface {
                    NavigationWrapper()
                }
            }
        }
    }
}