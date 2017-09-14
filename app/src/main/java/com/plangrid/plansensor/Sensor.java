package com.plangrid.plansensor;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Sensor {
    private static final String SENSOR_HOST = "http://my-sensor-api.herokuapp.com/";
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SENSOR_HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    private final SensorService sensorService = retrofit.create(SensorService.class);

    public Observable<DataPoint> getSensorObservable() {
        return Observable.interval(1, TimeUnit.SECONDS)
                         .subscribeOn(Schedulers.io())
                         .map(aLong -> sensorService.readSensor().execute().body());
    }
}
