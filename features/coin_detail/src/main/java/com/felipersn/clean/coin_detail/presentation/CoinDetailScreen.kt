package com.felipersn.clean.coin_detail.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.felipersn.clean.coin_detail.di.injectFeature
import com.felipersn.clean.coin_detail.presentation.components.CoinTag
import com.felipersn.clean.coin_detail.presentation.components.TeamListItem
import com.google.accompanist.flowlayout.FlowRow
import org.koin.androidx.compose.getViewModel

@Composable
fun CoinListScreen() {
    //viewModel and feature injection as singleton to avoid multiples instances
    injectFeature()
    val viewModel = getViewModel<CoinDetailViewModel>()
    //

    val state = viewModel.state.value

    Box(
        Modifier.fillMaxSize()
    ) {
        state.coin?.let { coin ->
            LazyColumn(
                Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(8f),
                        )

                        Text(
                            text = if (coin.isActive == true) "active" else "inactive",
                            color = if (coin.isActive == true) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(2f)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = coin.description ?: "",
                        style = MaterialTheme.typography.body2,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h3,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    FlowRow(
                        Modifier.fillMaxWidth(),
                        mainAxisSpacing = 8.dp,
                        crossAxisSpacing = 8.dp,
                    ) {
                        coin.tags?.forEach { tag ->
                            CoinTag(tag = tag)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Team members",
                        style = MaterialTheme.typography.h3,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    coin.team?.forEach { teamMember ->
                        TeamListItem(
                            teamMember = teamMember,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        )

                        Divider()
                    }
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