package com.example.cityweather.screen.citieslist

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.cityweather.R
import com.example.cityweather.data.pojo.City
import com.example.cityweather.di.Injectable
import com.example.cityweather.screen.wheatherdetails.WeatherDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject



class CitiesListActivity : MvpAppCompatActivity(), Injectable, CitiesListView {

    @Inject
    @InjectPresenter
    lateinit var presenter: CitiesListPresenter

    private val adapter : CitiesListAdapter = CitiesListAdapter {presenter.onItemCLickListener(it)}

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvCities.adapter = adapter
        rvCities.layoutManager = LinearLayoutManager(this)
    }

    override fun showCities(cities: List<City>) {
        adapter.setCities(cities)
    }

    override fun openWeatherDetailsScreen(city: String) {
        val intent = Intent(this, WeatherDetailsActivity::class.java)
        intent.putExtra(WeatherDetailsActivity.EXTRA_CITY_NAME,city)
        startActivity(intent)
    }
}
