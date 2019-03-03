package com.example.cityweather.screen.wheatherdetails

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.cityweather.R
import com.example.cityweather.data.pojo.City
import com.example.cityweather.di.Injectable
import com.example.cityweather.view.WeatherView
import kotlinx.android.synthetic.main.activity_weather_details.*
import javax.inject.Inject

class WeatherDetailsActivity : MvpAppCompatActivity(), Injectable, WeatherDetailsView {

    companion object {
        const val EXTRA_CITY_ID: String = "extra_city_id"
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: WeatherDetailsPresenter

    @ProvidePresenter
    fun providePresenter(): WeatherDetailsPresenter {
        presenter.cityId = intent?.getIntExtra(EXTRA_CITY_ID, 0)!!
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)
    }

    override fun showWeather(city: City) {
        val weather = city.weather
        weatherView.showWeather(
            WeatherView.WeatherModel(
                city.name,
                weather!!.temperature,
                weather.wind,
                weather.pressure,
                weather.clouds
            )
        )
    }
}
