package com.example.cityweather.data.repo

import com.example.cityweather.data.pojo.City
import com.example.cityweather.data.pojo.Weather
import io.reactivex.Single

interface Repository {
    fun loadCities(): Single<List<City>>

    fun loadWeather(name:String):Single<Weather>
}