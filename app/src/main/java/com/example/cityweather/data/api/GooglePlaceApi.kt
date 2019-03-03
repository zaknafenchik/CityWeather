package com.example.cityweather.data.api

import com.example.cityweather.data.api.dto.PlaceListDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GooglePlaceApi {
    companion object {
        const val APP_KEY = "AIzaSyBm1ha8wyoPYBVzooid0hgX63HW_kJgcak"
    }

    @GET("findplacefromtext/json")
    fun places(
        @Query("input") input: String,
        @Query("inputtype") inputType: String = "textquery",
        @Query("key") key: String = APP_KEY,
        @Query("fields") fields: String = "formatted_address,name,geometry"
    ): Single<PlaceListDTO>
}