package com.example.cityweather.data.api.dto

import com.google.gson.annotations.SerializedName

data class PlaceDTO(
    @SerializedName("formatted_address") val formattedAddress: String,
    val name: String,
    val geometry: GeometryDTO
)
