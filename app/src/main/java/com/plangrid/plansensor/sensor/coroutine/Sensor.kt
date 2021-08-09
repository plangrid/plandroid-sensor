package com.plangrid.plansensor.sensor.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class Sensor {

    private val random = Random()

    val sensorStream: Flow<Int>
        get() {
            // TODO(2): Replace with hitting an endpoint for a value every second.
            // return serverRetrievedSensorValues();
            return locallyGeneratedRandomNumbers()
        }

    private fun locallyGeneratedRandomNumbers(): Flow<Int> = flow {
        var counter = 0
        while (true) {
            emit(counter++)
            delay(1_000)
        }
    }

    private fun serverRetrievedSensorValues(): Flow<Int> {
        throw UnsupportedOperationException("Please implement.")
    }

}