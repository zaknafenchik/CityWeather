package com.example.cityweather.di

import android.content.Context
import com.example.cityweather.data.api.GooglePlaceApi
import com.example.cityweather.data.api.WeatherApi
import com.example.cityweather.di.qualifier.ApplicationContext
import com.google.gson.Gson
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    internal fun provideClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ChuckInterceptor(context))
            .build()
    }

    @Singleton
    @Provides
    @Named("weather_retrofit")
    internal fun provideWeatherRetrofit(
        client: OkHttpClient, @Named("weather_base_url") baseUrl: String,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    @Named("google_retrofit")
    internal fun provideGoogleRetrofit(
        client: OkHttpClient, @Named("google_place_base_url") baseUrl: String,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    internal fun provideApiService(@Named("weather_retrofit") retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }

    @Singleton
    @Provides
    internal fun provideGoogleApiService(@Named("google_retrofit") retrofit: Retrofit): GooglePlaceApi {
        return retrofit.create(GooglePlaceApi::class.java)
    }

    @Singleton
    @Named("weather_base_url")
    @Provides
    internal fun provideWeatherUrl(): String {
        return "http://api.openweathermap.org/data/2.5/"
    }

    @Singleton
    @Named("google_place_base_url")
    @Provides
    internal fun provideGoooglePlaceUrl(): String {
        return "https://maps.googleapis.com/maps/api/place/"
    }
}
