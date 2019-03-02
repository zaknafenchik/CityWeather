package com.example.cityweather.data.pojo


data class Weather(
    var temperature: Double,
    val pressure: Int,
    val clouds: Int,
    val humidity: Int,
    val wind: Double
)