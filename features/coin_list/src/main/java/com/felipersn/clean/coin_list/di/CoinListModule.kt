//package com.felipersn.clean.coin_list.di
//
//import com.felipersn.clean.coin_list.presentation.CoinListViewModel
//import com.felipersn.clean.domain.repository.CoinRepository
//import com.felipersn.clean.domain.usecases.get_coin_list.GetCoinListUseCase
//import com.felipersn.clean.network.services.CoinService
//import com.felipersn.clean.repository.CoinRepositoryImpl
//import org.koin.androidx.viewmodel.dsl.viewModel
//import org.koin.core.context.loadKoinModules
//import org.koin.dsl.module
//import retrofit2.Retrofit
//import retrofit2.create
//
//private val loadFeature by lazy { loadKoinModules(coinListModule) }
//internal fun injectFeature() = loadFeature
//
//val coinListModule = module {
//    //services
//    single<CoinService> { get<Retrofit>().create() }
//
//    //repositories
//    single<CoinRepository> { CoinRepositoryImpl(api = get()) }
//
//    //useCases
//    single { GetCoinListUseCase(repository = get()) }
//
//    //viewModels
//    viewModel { CoinListViewModel(getCoinListUseCase = get()) }
//}