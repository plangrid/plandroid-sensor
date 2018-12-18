package com.plangrid.plansensor;

import android.os.Bundle;

import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // The graph view to populate with sensor data
    @BindView(R.id.graph)
    Graph graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // display data in the graph by passing it a list of data points
        graph.setData(Arrays.asList(1, 5, 6, 4, 2, 1, 1, 3, 8));
    }
}
