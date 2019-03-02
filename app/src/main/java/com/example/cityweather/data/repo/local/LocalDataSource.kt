package com.example.cityweather.data.repo.local

import com.example.cityweather.data.pojo.City
import com.example.cityweather.data.pojo.Weather
import io.reactivex.Single

interface LocalDataSource {
    fun loadCities(): Single<List<City>>
    fun saveCity(city: City)
    fun loadWeather(name: String): Single<Weather>
}