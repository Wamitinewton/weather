package com.example.weather.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weather.data.mappers.toWeatherInfo
import com.example.weather.data.remote.WeatherApi
import com.example.weather.domain.models.WeatherInfo
import com.example.weather.domain.repository.WeatherRepository
import com.example.weather.util.Resource
import okio.IOException
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Error(e.message ?: "could not fetch the weather Data")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Unknown error has occurred")
        }
    }
}