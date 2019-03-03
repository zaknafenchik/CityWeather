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
                .doOnSubscribe { viewState.showProgress(true) }
                .doAfterTerminate { viewState.showProgress(false) }
                .subscribe({
                    viewState.showCities(it)
                }, { Log.d(TAG, it.message) })
        )
    }

    fun onItemCLickListener(id: Int) {
        viewState.openWeatherDetailsScreen(id)
    }

    fun onAddCityClick() {
        viewState.showAddCityScreen()
    }

    fun findCity(query: String) {
        compositeDisposable.add(
            repo.findCity(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showProgress(true) }
                .doAfterTerminate { viewState.showProgress(false) }
                .subscribe({
                    viewState.showCity(it)
                }, { viewState.showMessage(it.message) })
        )
    }
}