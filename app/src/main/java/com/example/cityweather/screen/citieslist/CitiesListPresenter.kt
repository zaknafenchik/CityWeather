package com.example.cityweather.screen.citieslist

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.example.cityweather.data.repo.Repository
import com.example.cityweather.screen.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class CitiesListPresenter(private val repo: Repository) : BasePresenter<CitiesListView>() {

    companion object {
        private val TAG = CitiesListPresenter::class.simpleName
    }

    init {
        loadCities()
    }

    private fun loadCities() {
        compositeDisposable.add(
            repo.loadCities()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.showCities(it)
                }, { Log.d(TAG, it.message) })
        )
    }

    fun onItemCLickListener(id: Int) {
        viewState.openWeatherDetailsScreen(id)
    }
}