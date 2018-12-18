package com.plangrid.plansensor;

import android.os.Bundle;

import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The graph view to populate with sensor data
        Graph graph = (Graph) findViewById(R.id.graph);
        // display data in the graph by passing it a list of data points
        graph.setData(Arrays.asList(1, 5, 6, 4, 2, 1, 1, 3, 8));
    }
}
