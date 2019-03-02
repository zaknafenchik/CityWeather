package com.example.cityweather.screen.citieslist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cityweather.R
import com.example.cityweather.data.pojo.City
import kotlinx.android.synthetic.main.recycler_cities_list_item.view.*
import java.util.*

class CitiesListAdapter (val itemClickListener: (name: String) -> Unit) : RecyclerView.Adapter<CitiesListAdapter.CitiesListVH>() {
    private val cities = ArrayList<City>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CitiesListVH {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.recycler_cities_list_item, viewGroup, false)
        return CitiesListVH(view)
    }

    override fun onBindViewHolder(vh: CitiesListVH, i: Int) {
        val city  = cities[i]
        vh.itemView.tvCityName.text = city.name
        vh.itemView.tvTemperature.text = city.weather?.temperature.toString()
        vh.itemView.setOnClickListener { itemClickListener(city.name) }
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    fun setCities(list: List<City>) {
        cities.clear()
        cities.addAll(list)
        notifyDataSetChanged()
    }

    fun addCity(city: City) {
        cities.add(city)
        notifyItemInserted(cities.size - 1)
    }

    class CitiesListVH(itemView: View) : RecyclerView.ViewHolder(itemView)
}
