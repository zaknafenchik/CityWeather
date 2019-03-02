package com.example.cityweather.screen.citieslist

import com.example.cityweather.data.repo.Repository
import dagger.Module
import dagger.Provides

@Module
class CitiesListModule {

    @Provides
    fun providePresenter(repository: Repository) = CitiesListPresenter(repository)
}
