package com.example.cityweather.data.repo.remote

import com.example.cityweather.data.api.GooglePlaceApi
import com.example.cityweather.data.api.WeatherApi
import com.example.cityweather.data.pojo.City
import com.example.cityweather.data.pojo.Weather
import io.reactivex.Single

class CloudDataSource(
    private val weatherApi: WeatherApi,
    private val googlePlaceApi: GooglePlaceApi
) : RemoteDataSource {
    override fun loadWeather(lat: Double, lon: Double): Single<Weather> {
        return weatherApi.loadWeather(lat, lon)
            .map { Weather(it.main.temp, it.main.pressure, it.clouds.all, it.main.humidity, it.wind.speed) }
    }

    override fun findCity(query: String): Single<List<City>> {
        return googlePlaceApi.places(query)
            .map { (candidates) ->
                val cities = arrayListOf<City>()
                for ((_, name1, geometry) in candidates) {
                    val location = geometry.location
                    cities.add(City(name1, location.lat, location.lng))
                }
                cities
            }
    }
}