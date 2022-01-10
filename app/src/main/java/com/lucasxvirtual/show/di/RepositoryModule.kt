package com.lucasxvirtual.show.di

import com.lucasxvirtual.data.remote.SeasonService
import com.lucasxvirtual.data.remote.ShowService
import com.lucasxvirtual.data.repository.SeasonRepository
import com.lucasxvirtual.data.repository.SeasonRepositoryImpl
import com.lucasxvirtual.data.repository.ShowRepository
import com.lucasxvirtual.data.repository.ShowRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

/**
 * Dependency injection for repository classes.
 */

@InstallIn(ActivityComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideShowRepository(showService: ShowService): ShowRepository {
        return ShowRepositoryImpl(showService)
    }

    @Provides
    @Singleton
    fun provideSeasonRepository(seasonService: SeasonService): SeasonRepository {
        return SeasonRepositoryImpl(seasonService)
    }
}