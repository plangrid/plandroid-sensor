package com.plangrid.plansensor.sensor.rx

import com.plangrid.plansensor.DataPoint
import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit

class Sensor {

    private val random = Random()

    val sensorStream: Observable<Int>
        get() {
            return locallyGeneratedRandomNumbers()
        }

    private fun locallyGeneratedRandomNumbers(): Observable<Int> {
        return Observable.interval(1, TimeUnit.SECONDS)
            .map { random.nextInt() }
    }

}