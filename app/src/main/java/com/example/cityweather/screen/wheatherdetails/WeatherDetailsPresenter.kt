package com.example.cityweather.screen.wheatherdetails

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.example.cityweather.data.repo.Repository
import com.example.cityweather.screen.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class WeatherDetailsPresenter(private val repo: Repository) : BasePresenter<WeatherDetailsView>() {
    companion object {
        val TAG: String = WeatherDetailsPresenter::class.java.simpleName
    }

    var cityName: String? = null
        set(value) {
            field = value
            field?.let { loadCity(it) }
        }

    private fun loadCity(name: String) {
        compositeDisposable.add(repo.loadWeather(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, it.toString())
                viewState.showWeather(it) }, { t -> Log.d(TAG, t.message) })
        )
    }
}