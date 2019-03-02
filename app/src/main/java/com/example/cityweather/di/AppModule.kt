package com.example.cityweather.di

import android.arch.persistence.room.Room
import android.content.Context
import com.example.cityweather.App
import com.example.cityweather.data.api.WeatherApi
import com.example.cityweather.data.repo.RepoImpl
import com.example.cityweather.data.repo.Repository
import com.example.cityweather.data.repo.local.CityWeatherDAO
import com.example.cityweather.data.repo.local.CityWeatherDB
import com.example.cityweather.data.repo.local.DiskDataSource
import com.example.cityweather.data.repo.local.LocalDataSource
import com.example.cityweather.data.repo.remote.CloudDataSource
import com.example.cityweather.data.repo.remote.RemoteDataSource
import com.example.cityweather.di.qualifier.ApplicationContext
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @ApplicationContext
    @Singleton
    fun provideContext(app: App): Context = app

    @Provides
    @Singleton
    fun provideRepository(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource): Repository {
        return RepoImpl(remoteDataSource, localDataSource)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(cityWeatherDAO: CityWeatherDAO): LocalDataSource {
        return DiskDataSource(cityWeatherDAO)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(weatherApi: WeatherApi): RemoteDataSource {
        return CloudDataSource(weatherApi)
    }

    @Provides
    @Singleton
    fun provideDogWalkerDB(@ApplicationContext context: Context): CityWeatherDB {
        return Room.databaseBuilder(context, CityWeatherDB::class.java, "city_weather_db_new")
            .build()
    }

    @Provides
    @Singleton
    internal fun provideDogWalkerDAO(cityWeatherDB: CityWeatherDB): CityWeatherDAO {
        return cityWeatherDB.cityWeatherDao()
    }
}