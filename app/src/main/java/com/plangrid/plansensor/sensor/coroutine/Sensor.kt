package com.plangrid.plansensor.sensor.coroutine

import com.plangrid.plansensor.DataPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class Sensor {

    private val random = Random()

    val sensorStream: Flow<Int>
        get() {
            return locallyGeneratedRandomNumbers()
        }

    private fun locallyGeneratedRandomNumbers(): Flow<Int> = flow {
        while (true) {
            emit(random.nextInt())
            delay(1_000)
        }
    }

}