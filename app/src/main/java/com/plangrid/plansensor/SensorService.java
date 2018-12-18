package com.plangrid.plansensor;


import retrofit2.Call;
import retrofit2.http.GET;

public interface SensorService {
    @GET("sensor-problem")
    Call<DataPoint> readSensor();
}
