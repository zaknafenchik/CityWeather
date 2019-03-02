package com.example.cityweather.screen.wheatherdetails

import com.arellomobile.mvp.MvpView
import com.example.cityweather.data.pojo.City

interface WeatherDetailsView : MvpView {
    fun showWeather(weather: City)
}