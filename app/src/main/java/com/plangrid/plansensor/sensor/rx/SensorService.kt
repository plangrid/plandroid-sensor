package com.plangrid.plansensor.sensor.rx

import com.plangrid.plansensor.DataPoint
import io.reactivex.Single
import retrofit2.http.GET

interface SensorService {
    @GET("sensor-problem")
    fun readSensor(): Single<DataPoint>
}