package com.example.cityweather.data.repo.remote

import com.example.cityweather.data.pojo.Weather
import io.reactivex.Single

interface RemoteDataSource {

    fun loadWeather(lat:Double, lon:Double): Single<Weather>
}