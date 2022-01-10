package com.lucasxvirtual.show.di

import com.lucasxvirtual.data.remote.ShowService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

/**
 * Dependency injection for remote data source classes.
 */

@InstallIn(ActivityComponent::class)
@Module
class ServiceModule {

    @Singleton
    @Provides
    fun provideShowService(): ShowService {
        return ShowService.create()
    }

}