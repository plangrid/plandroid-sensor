package com.plangrid.plansensor

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import com.plangrid.plansensor.sensor.coroutine.Sensor as FlowSensor
import com.plangrid.plansensor.sensor.rx.Sensor as RxSensor


class MainActivity : AppCompatActivity() {

    companion object {
        const val MAX_VALUES = 10
    }

    private val values = LengthLimitedList<Int>(MAX_VALUES)

//    private val rxSensor = RxSensor()  // TODO: uncomment for Rx option
//    private val disposables = CompositeDisposable()  // TODO: uncomment for Rx option

    private val flowSensor = FlowSensor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Display data in the graph by passing it a list of data points.
        val graphView: GraphView = findViewById(R.id.graph)
        graphView.setData(listOf(1, 5, 6, 4, 2, 1, 1, 3, 8))

        // TODO(1): Listen to the sensor and display a running list of the most recent ten values in the graph.
        val record = findViewById<Button>(R.id.record)
        record.setOnClickListener {
            // TODO: Implement recording
        }
        val play = findViewById<Button>(R.id.play)
        play.setOnClickListener {
            // TODO: Implement playback
        }

        // TODO(1): Listen to the sensor and display the last ten values in the graph.

//        disposables.add(
//            rxSensor
//                .sensorStream
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe {
//                    Log.v("RxSensor", "Value: $it")
//                    values.add(it)
//                    graphView.setData(values)
//                }
//        )

        lifecycleScope
            .launch {
                flowSensor
                    .sensorStream
                    .flowOn(Dispatchers.IO)
                    .collect {
                        values.add(it)
                        graphView.setData(values)
                    }
            }
    }

    override fun onDestroy() {
//        disposables.clear() // TODO: uncomment for Rx option
        super.onDestroy()
    }
}
