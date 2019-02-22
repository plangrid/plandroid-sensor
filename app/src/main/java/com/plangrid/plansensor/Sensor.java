package com.plangrid.plansensor;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class Sensor {

    private Random random = new Random();

    public Observable<Integer> getSensorObservable() {
        // TODO(2): Replace with hitting an endpoint for a value every second.
//        return serverRetrievedSensorValues();

        return locallyGeneratedRandomNumbers();
    }

    private Observable<Integer> locallyGeneratedRandomNumbers() {
        return Observable.interval(1, TimeUnit.SECONDS)
                .map(it -> random.nextInt())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<Integer> serverRetrievedSensorValues() {
        throw new UnsupportedOperationException("Please implement.");
    }
}