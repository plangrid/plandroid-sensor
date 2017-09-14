package com.plangrid.plansensor;


import com.plangrid.plansensor.DataPoint;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SensorService {
    @GET("meter")
    Call<DataPoint> readSensor();
}
