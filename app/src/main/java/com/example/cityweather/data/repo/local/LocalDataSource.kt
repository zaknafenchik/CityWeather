package com.example.cityweather.data.repo.local

import com.example.cityweather.data.pojo.City
import io.reactivex.Single

interface LocalDataSource {
    fun loadCities(): Single<List<City>>
    fun updateCity(city: City)
    fun loadCity(id: Int): Single<City>
}