package com.example.cityweather.data.repo.remote

import com.example.cityweather.data.api.WeatherApi
import com.example.cityweather.data.pojo.Weather
import io.reactivex.Single

class CloudDataSource(private val weatherApi: WeatherApi) : RemoteDataSource {
    override fun loadWeather(lat: Double, lon: Double): Single<Weather> {
     return   weatherApi.loadWeather(lat, lon)
            .map { Weather( it.main.temp, it.main.pressure, it.clouds.all, it.main.humidity, it.wind.speed) }
    }
}