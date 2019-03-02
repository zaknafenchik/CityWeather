package com.example.cityweather.screen.wheatherdetails

import com.arellomobile.mvp.MvpView
import com.example.cityweather.data.pojo.Weather

interface WeatherDetailsView : MvpView {
    fun showWeather(weather: Weather)
}