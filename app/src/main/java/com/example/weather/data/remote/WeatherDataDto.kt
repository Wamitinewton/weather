package com.example.weather.data.remote

import com.squareup.moshi.Json

data class WeatherDataDto(
    val time: List<String>,
    @field:Json(name = "temperature_2m")
    val temperature: List<Double>,
    @field:Json(name = "weathercode")
    val weatherCodes: List<Int>,
    @field:Json(name = "pressure_msl")
    val pressures: List<Double>,
    @field: Json(name = "wind_speed_10m")
    val windSpeed: List<Double>,
    @field:Json(name = "relative_humidity_2m")
    val relativeHumidity: List<Double>,

    )
