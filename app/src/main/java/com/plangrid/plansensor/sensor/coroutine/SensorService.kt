package com.plangrid.plansensor.sensor.coroutine

import com.plangrid.plansensor.DataPoint
import retrofit2.http.GET

interface SensorService {
    @GET("sensor-problem")
    suspend fun readSensor(): DataPoint
}