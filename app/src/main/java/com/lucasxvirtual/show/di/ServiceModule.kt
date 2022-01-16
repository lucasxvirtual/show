package com.lucasxvirtual.show.di

import com.lucasxvirtual.data.remote.SeasonService
import com.lucasxvirtual.data.remote.ShowService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dependency injection for remote data source classes.
 */

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun provideShowService(): ShowService {
        return ShowService.create()
    }

    @Provides
    @Singleton
    fun provideSeasonService(): SeasonService {
        return SeasonService.create()
    }

}