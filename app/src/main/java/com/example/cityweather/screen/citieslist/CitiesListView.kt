package com.example.cityweather.screen.citieslist

import com.arellomobile.mvp.MvpView
import com.example.cityweather.data.pojo.City

interface CitiesListView : MvpView {
    fun showCities(cities: List<City>)

    fun openWeatherDetailsScreen(city: String)
}