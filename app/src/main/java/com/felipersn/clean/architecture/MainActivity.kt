package com.felipersn.clean.architecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.felipersn.clean.architecture.ui.theme.Clean_architecture_composeTheme
import com.felipersn.clean.coin_detail.presentation.CoinDetailScreen
import com.felipersn.clean.coin_list.presentation.CoinListScreen
import com.felipersn.clean.core.common.Constants
import com.felipersn.clean.navigation.NavigationManager
import com.felipersn.clean.navigation.NavigationRoutes
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Clean_architecture_composeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    HandlerNavigationTrigger(
                        navController = navController
                    )

                    NavHost(
                        navController = navController,
                        startDestination = NavigationRoutes.COIN_LIST.get,
                    ) {
                        composable(
                            route = NavigationRoutes.COIN_LIST.get,
                        ) {
                            CoinListScreen()
                        }
                        composable(
                            route = NavigationRoutes.COIN_DETAIL.get + "/{${Constants.PARAM_COIN_ID}}",
                            arguments = listOf(navArgument(Constants.PARAM_COIN_ID) {
                                type = NavType.StringType
                            })
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HandlerNavigationTrigger(
    navController: NavController
) {
    var launchedEffectSetupDone by rememberSaveable { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    if (!launchedEffectSetupDone) {
        LaunchedEffect(Unit) {
            launchedEffectSetupDone = true
            coroutineScope.launch {
                NavigationManager.navigationTrigger.collect { destination ->
                    if (destination.isNotEmpty()) {
                        navController.navigate(destination)
                    }
                }
            }
        }
    }
}

