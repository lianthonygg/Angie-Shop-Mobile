package com.zyphir.eccomerce.angieshop.features.profile.presentation.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zyphir.eccomerce.angieshop.Greeting

@Composable
fun ProfileView() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Profile",
            modifier = Modifier.padding(innerPadding)
        )
    }
}