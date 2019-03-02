package com.example.cityweather.data.repo.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.cityweather.data.pojo.City
import com.example.cityweather.data.pojo.Weather

@Database(entities = [City::class, Weather::class], version = 1)
abstract class CityWeatherDB : RoomDatabase(){
    abstract fun cityWeatherDao(): CityWeatherDAO
}