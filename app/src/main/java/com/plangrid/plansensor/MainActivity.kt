package com.plangrid.plansensor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Display data in the graph by passing it a list of data points.
        val graphView: GraphView = findViewById(R.id.graph)
        graphView.setData(Arrays.asList(1, 5, 6, 4, 2, 1, 1, 3, 8))

        // TODO(1): Listen to the sensor and display the last ten values in the graph.
    }
}
