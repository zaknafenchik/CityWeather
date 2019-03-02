package com.example.cityweather.util

import com.example.cityweather.data.pojo.City

object CityProvider {
    fun provideCities(): List<City> {
        val cities = arrayListOf<City>()
        cities.add(City("Kiev", 50.4547, 30.5238))
        cities.add(City("Lviv", 49.8383, 24.0232))
        cities.add(City("Kharkiv", 49.9808, 36.25272))
        return cities
    }
}