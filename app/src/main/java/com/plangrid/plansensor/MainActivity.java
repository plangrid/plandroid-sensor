package com.plangrid.plansensor;

import android.os.Bundle;

import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Display data in the graph by passing it a list of data points.
        final GraphView graphView = findViewById(R.id.graph);
        graphView.setData(Arrays.asList(1, 5, 6, 4, 2, 1, 1, 3, 8));

        // TODO(1): Listen to the sensor and display the last ten values in the graph.
    }
}
