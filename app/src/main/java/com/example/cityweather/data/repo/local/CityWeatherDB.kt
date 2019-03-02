package com.example.cityweather.data.repo.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.cityweather.data.pojo.City

@Database(entities = [City::class], version = 1)
abstract class CityWeatherDB : RoomDatabase() {
    abstract fun cityWeatherDao(): CityWeatherDAO
}