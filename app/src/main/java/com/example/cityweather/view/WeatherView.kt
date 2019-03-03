package com.example.cityweather.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.cityweather.R
import kotlinx.android.synthetic.main.view_weather.view.*

class WeatherView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_weather, this)
    }

    fun showWeather(weather: WeatherModel) {
        tvCity.text = weather.name
        tvPressure.text = weather.pressure.toString()
        tvTemp.text = weather.temp.toString()
        tvWind.text = weather.wind.toString()

        weather.clouds.let {
            if (weather.clouds!! > 50) {
                ivClouds.setImageResource(R.drawable.ic_cloud)
            } else {
                ivClouds.setImageResource(R.drawable.ic_sun)
            }
        }
    }

    class WeatherModel(
        val name: String,
        var temp: Double?,
        var wind: Double?,
        var pressure: Int?,
        var clouds: Int?
    )
}
