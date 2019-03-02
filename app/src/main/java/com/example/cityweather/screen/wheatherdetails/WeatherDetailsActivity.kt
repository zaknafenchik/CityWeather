package com.example.cityweather.screen.wheatherdetails

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.cityweather.R
import com.example.cityweather.data.pojo.Weather
import com.example.cityweather.di.Injectable
import javax.inject.Inject

class WeatherDetailsActivity : MvpAppCompatActivity(), Injectable, WeatherDetailsView {

    companion object {
        const val EXTRA_CITY_NAME: String = "extra_city_name"
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: WeatherDetailsPresenter

    @ProvidePresenter
    fun providePresenter(): WeatherDetailsPresenter {
        presenter.cityName = intent?.getStringExtra(EXTRA_CITY_NAME)
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)
    }

    override fun showWeather(weather: Weather) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
