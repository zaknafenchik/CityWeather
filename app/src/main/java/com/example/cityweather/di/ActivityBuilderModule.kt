package com.example.cityweather.di


import com.example.cityweather.screen.citieslist.CitiesListActivity
import com.example.cityweather.screen.citieslist.CitiesListModule
import com.example.cityweather.screen.wheatherdetails.WeatherDetailsActivity
import com.example.cityweather.screen.wheatherdetails.WeatherDetailsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [CitiesListModule::class])
    abstract fun contributeMainActivity(): CitiesListActivity

    @ContributesAndroidInjector(modules = [WeatherDetailsModule::class])
    abstract fun contributeWeatherDetailsScreen(): WeatherDetailsActivity
}