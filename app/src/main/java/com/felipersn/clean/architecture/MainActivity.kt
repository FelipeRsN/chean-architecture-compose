package com.felipersn.clean.architecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.felipersn.clean.architecture.ui.theme.Clean_architecture_composeTheme
import com.felipersn.clean.core.common.NavigationUtils

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Clean_architecture_composeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavigationUtils.CoinListScreen.route,
                    ) {
                        composable(
                            route = NavigationUtils.CoinListScreen.route
                        ){
                            
                        }
                    }
                }
            }
        }
    }
}

