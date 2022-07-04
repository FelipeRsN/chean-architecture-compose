package com.felipersn.di

import com.felipersn.clean.network.services.CoinService
import com.felipersn.clean.repository.repositories.CoinRepositoryImpl
import com.felipersn.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /**
     * Repository Module used to generate repositories instances
     **/

    @Provides
    @Singleton
    fun provideCoinRepository(service: CoinService): CoinRepository {
        return CoinRepositoryImpl(service)
    }
}