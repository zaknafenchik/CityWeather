package com.example.cityweather.data.api

import com.example.cityweather.data.api.dto.WeatherDTO
import com.example.cityweather.data.pojo.Weather
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    companion object {
        const val APP_ID = "b8103d60b7e5c04a6380e236512d2d3e"
    }

    @GET("weather")
    fun loadWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("APPID") appId: String = APP_ID,
        @Query("units")units: String = "metric"
    ): Single<WeatherDTO>
}