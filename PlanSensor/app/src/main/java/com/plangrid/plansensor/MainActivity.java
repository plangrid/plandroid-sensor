package com.plangrid.plansensor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The graph view to populate with sensor data
        Graph graph = (Graph) findViewById(R.id.graph);
        // display data in the graph by passing it an int array of data points
        graph.setData(new int[] {1, 5, 6, 4, 2, 1, 1, 3, 8});
    }
}
