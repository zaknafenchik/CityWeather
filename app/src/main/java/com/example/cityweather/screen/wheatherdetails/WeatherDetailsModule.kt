package com.example.cityweather.screen.wheatherdetails

import com.example.cityweather.data.repo.Repository
import dagger.Module
import dagger.Provides

@Module
class WeatherDetailsModule {

    @Provides
    fun providePresenter(repository: Repository) = WeatherDetailsPresenter(repository)
}