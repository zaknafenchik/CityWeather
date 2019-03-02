package com.example.cityweather.data.repo.local


import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.cityweather.data.pojo.City
import com.example.cityweather.data.pojo.Weather
import io.reactivex.Single

@Dao
interface CityWeatherDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCities(cities: List<City>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCity(city: City)

    @Query("SELECT * FROM cities")
    fun loadCities(): Single<List<City>>

    @Query("SELECT * FROM weather WHERE city_name = :cityName")
    fun loadWeather(cityName: String): Single<Weather>
}

