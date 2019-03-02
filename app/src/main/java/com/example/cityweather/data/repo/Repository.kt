package com.example.cityweather.data.repo

import com.example.cityweather.data.pojo.City
import io.reactivex.Single

interface Repository {
    fun loadCities(): Single<List<City>>

    fun loadCIty(id: Int): Single<City>
}