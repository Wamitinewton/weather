package com.example.weather.domain.repository

import com.example.weather.domain.models.WeatherData
import com.example.weather.domain.models.WeatherInfo
import com.example.weather.util.Resource

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}