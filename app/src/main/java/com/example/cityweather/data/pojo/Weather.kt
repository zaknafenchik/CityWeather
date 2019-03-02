package com.example.cityweather.data.pojo

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

//@Entity(tableName = "weather")
data class Weather(
//    @PrimaryKey
////    @ColumnInfo(name = "city_name")
    var cityName: String = "",
    var temperature: Double,
    val pressure: Int,
    val clouds : Int,
    val humidity : Int,
    val wind : Double
)