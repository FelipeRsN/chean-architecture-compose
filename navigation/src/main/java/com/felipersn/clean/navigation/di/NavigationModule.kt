package com.felipersn.clean.navigation.di

import com.felipersn.clean.navigation.NavigationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    /**
     * Navigation Module used to generate navigation classes to be provided to all features
     **/

    @Provides
    @Singleton
    fun provideNavigationManager() = NavigationManager()
}