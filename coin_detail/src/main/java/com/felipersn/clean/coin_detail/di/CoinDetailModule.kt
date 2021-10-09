package com.felipersn.clean.coin_detail.di

import androidx.lifecycle.SavedStateHandle
import com.felipersn.clean.coin_detail.presentation.CoinDetailViewModel
import com.felipersn.clean.data.remote.CoinService
import com.felipersn.clean.data.repository.CoinRepositoryImpl
import com.felipersn.clean.domain.usecases.get_coin_list.GetCoinListUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

private val loadFeature by lazy { loadKoinModules(coinDetailModule) }
internal fun injectFeature() = loadFeature

val coinDetailModule = module {
    //services
    single<CoinService> { get<Retrofit>().create() }

    //repositories
    single { CoinRepositoryImpl(api = get()) }

    //useCases
    single { GetCoinListUseCase(repository = get()) }

    //viewModels
    viewModel { (handle: SavedStateHandle) ->
        CoinDetailViewModel(
            getCoinUseCase = get(),
            savedStateHandle = handle
        )
    }
}