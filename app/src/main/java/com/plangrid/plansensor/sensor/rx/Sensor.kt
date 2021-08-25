package com.plangrid.plansensor.sensor.rx

import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit

class Sensor {

    private val random = Random()

    val sensorStream: Observable<Int>
        get() {
            // TODO(2): Replace with hitting an endpoint for a value every second.
            // return serverRetrievedSensorValues();
            return locallyGeneratedRandomNumbers()
        }

    private fun locallyGeneratedRandomNumbers(): Observable<Int> {
        return Observable.interval(1, TimeUnit.SECONDS)
            .map { random.nextInt() }
    }

    private fun serverRetrievedSensorValues(): Observable<Int> {
        throw UnsupportedOperationException("Please implement.")
    }

}