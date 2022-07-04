package com.felipersn.clean.coin_list.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felipersn.clean.navigation.NavigationManager
import com.felipersn.clean.navigation.routes.CoinDetailRoutes
import com.felipersn.domain.model.Coin
import com.felipersn.domain.usecase.get_coin_list.GetCoinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinListUseCase: GetCoinListUseCase,
    private val navigationManager: NavigationManager
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinListUseCase().onEach { result ->
            when (result) {
                is com.felipersn.core.utils.Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is com.felipersn.core.utils.Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
                is com.felipersn.core.utils.Resource.Error -> {
                    _state.value = CoinListState(error = result.exception)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun navigateToDetail(coin: Coin) {
        viewModelScope.launch {
            navigationManager.navigateTo(CoinDetailRoutes.root(coin.id))
        }
    }
}