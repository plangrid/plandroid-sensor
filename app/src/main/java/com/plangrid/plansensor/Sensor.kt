package com.plangrid.plansensor

import java.util.Random
import java.util.concurrent.TimeUnit

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class Sensor {
    private val random = Random()

    val sensorObservable: Observable<Int>
        get() =// TODO(2): Replace with hitting an endpoint for a value every second.
            //        return serverRetrievedSensorValues();
            locallyGeneratedRandomNumbers()

    private fun locallyGeneratedRandomNumbers(): Observable<Int> {
        return Observable.interval(1, TimeUnit.SECONDS)
            .map { it -> random.nextInt() }
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun serverRetrievedSensorValues(): Observable<Int> {
        throw UnsupportedOperationException("Please implement.")
    }
}