package com.example.cityweather.data.pojo

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "cities")
data class City(
    @PrimaryKey val name: String,
    val lat: Double, val lon: Double,
    @Embedded var weather: Weather? = null
)