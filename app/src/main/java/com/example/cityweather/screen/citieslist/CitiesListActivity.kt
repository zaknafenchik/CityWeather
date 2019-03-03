package com.example.cityweather.screen.citieslist


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.cityweather.R
import com.example.cityweather.data.pojo.City
import com.example.cityweather.di.Injectable
import com.example.cityweather.screen.wheatherdetails.WeatherDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_add_city.view.*
import javax.inject.Inject


class CitiesListActivity : MvpAppCompatActivity(), Injectable, CitiesListView {

    @Inject
    @InjectPresenter
    lateinit var presenter: CitiesListPresenter

    private val adapter: CitiesListAdapter = CitiesListAdapter { presenter.onItemCLickListener(it) }

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        fabAddCity.setOnClickListener { presenter.onAddCityClick() }
    }

    private fun initRecyclerView() {
        rvCities.adapter = adapter
        rvCities.layoutManager = LinearLayoutManager(this)
    }

    override fun showCities(cities: List<City>) {
        adapter.setCities(cities)
    }

    override fun openWeatherDetailsScreen(cityId: Int) {
        val intent = Intent(this, WeatherDetailsActivity::class.java)
        intent.putExtra(WeatherDetailsActivity.EXTRA_CITY_ID, cityId)
        startActivity(intent)
    }

    override fun showAddCityScreen() {

        val view = LayoutInflater.from(this).inflate(com.example.cityweather.R.layout.dialog_add_city, null, false)

        val alertDialog = AlertDialog.Builder(this)
            .setView(view)
            .setPositiveButton("Add", null)
            .create()

        alertDialog.setOnShowListener {
            val button = (alertDialog as AlertDialog).getButton(AlertDialog.BUTTON_POSITIVE)
            button.setOnClickListener {
                val query = view.etQuery.text.toString()
                if (TextUtils.isEmpty(query) || query.length < 3) {
                    view.etQuery.error = "Least 3 letters"
                } else {
                    presenter.findCity(query)
                    alertDialog.dismiss()
                }
            }
        }
        alertDialog.show()
    }

    override fun showMessage(message: String?) {
        message.let { Toast.makeText(this, message, Toast.LENGTH_LONG).show() }
    }

    override fun showCity(it: City) {
        adapter.addCity(it)
    }

    override fun showProgress(show: Boolean) {
        progressBar.visibility = when (show) {
            true -> View.VISIBLE
            else -> View.GONE
        }
    }
}
