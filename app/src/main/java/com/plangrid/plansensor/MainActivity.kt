package com.plangrid.plansensor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Display data in the graph by passing it a list of data points.
        val graphView: GraphView = findViewById(R.id.graph)
        graphView.setData(listOf(1, 5, 6, 4, 2, 1, 1, 3, 8))

        // TODO(1): Listen to the sensor and display a running list of the previous ten values in the graph.

    }
}
