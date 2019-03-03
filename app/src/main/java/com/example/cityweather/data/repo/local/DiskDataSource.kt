package com.example.cityweather.data.repo.local

import com.example.cityweather.data.pojo.City
import com.example.cityweather.util.CityProvider
import io.reactivex.Single

class DiskDataSource(private val cityWeatherDAO: CityWeatherDAO) : LocalDataSource {
    override fun loadCities(): Single<List<City>> {
        return cityWeatherDAO.loadCities()
            .map {
                if (it.isEmpty()) {
                    cityWeatherDAO.insertCities(CityProvider.provideCities())
                    return@map CityProvider.provideCities()
                }
                return@map it
            }
    }

    override fun updateCity(city: City) {
        cityWeatherDAO.updateCity(city)
    }

    override fun loadCity(id: Int): Single<City> {
        return cityWeatherDAO.loadCity(id)
    }

    override fun saveCity(city: City): Int {
        return cityWeatherDAO.insertCity(city).toInt()
    }
}