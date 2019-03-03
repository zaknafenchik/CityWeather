package com.example.cityweather.data.repo.local


import android.arch.persistence.room.*
import com.example.cityweather.data.pojo.City
import io.reactivex.Single

@Dao
interface CityWeatherDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCities(cities: List<City>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCity(city: City): Long

    @Update
    fun updateCity(city: City)

    @Query("SELECT * FROM cities")
    fun loadCities(): Single<List<City>>

    @Query("SELECT * FROM cities WHERE id = :cityId")
    fun loadCity(cityId: Int): Single<City>
}

