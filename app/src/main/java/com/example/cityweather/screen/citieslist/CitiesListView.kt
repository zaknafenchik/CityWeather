package com.example.cityweather.screen.citieslist

import com.arellomobile.mvp.MvpView
import com.example.cityweather.data.pojo.City

interface CitiesListView : MvpView {
    fun showCities(cities: List<City>)

    fun openWeatherDetailsScreen(cityId: Int)

    fun showAddCityScreen()
    fun showMessage(message: String?)
    fun showCity(it: City)
    fun showProgress(show: Boolean)
}