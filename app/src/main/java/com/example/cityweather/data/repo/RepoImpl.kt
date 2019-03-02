package com.example.cityweather.data.repo

import android.util.Log
import com.example.cityweather.data.pojo.City
import com.example.cityweather.data.repo.local.LocalDataSource
import com.example.cityweather.data.repo.remote.RemoteDataSource
import io.reactivex.Single

class RepoImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {

    override fun loadCIty(id: Int): Single<City> {
        return localDataSource.loadCity(id)
    }

    companion object {
        private val TAG = RepoImpl::class.simpleName
    }

    override fun loadCities(): Single<List<City>> {
        return localDataSource.loadCities()
            .map { cities ->
                for (city in cities) {
                    remoteDataSource.loadWeather(city.lat, city.lon)
                        .subscribe({ weather ->
                            city.weather = weather
                            localDataSource.updateCity(city)
                        }, { t -> Log.d(TAG, t.message) })
                }
                cities
            }
    }
}