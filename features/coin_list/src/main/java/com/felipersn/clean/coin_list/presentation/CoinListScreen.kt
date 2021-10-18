package com.felipersn.clean.coin_list.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.felipersn.clean.coin_list.di.injectFeature
import com.felipersn.clean.coin_list.presentation.components.CoinListItem
import com.felipersn.clean.core.common.NavigationUtils
import org.koin.androidx.compose.getViewModel

@Composable
fun CoinListScreen(
    navController: NavController,
) {
    //viewModel and feature injection as singleton to avoid multiples instances
    injectFeature()
    val viewModel = getViewModel<CoinListViewModel>()
    //

    val state = viewModel.state.value

    Box(
        Modifier.fillMaxSize()
    ) {
        LazyColumn(
            Modifier.fillMaxSize()
        ) {
            items(state.coins) { coin ->
                CoinListItem(
                    coin = coin
                ) {
                    navController.navigate(NavigationUtils.CoinDetailScreen.route + "/${it.id}")
                }
            }
        }

        if (!state.error?.message.isNullOrEmpty()) {
            Text(
                text = state.error?.message!!,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                Modifier.align(Alignment.Center)
            )
        }
    }

}