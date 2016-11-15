package com.plangrid.plansensor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Graph graph = (Graph) findViewById(R.id.graph);
        graph.setData(new int[] {1, 5, 6, 4, 2, 1, 1, 3, 8});
    }
}
