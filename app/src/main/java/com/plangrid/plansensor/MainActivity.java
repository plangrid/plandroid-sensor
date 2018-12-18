package com.plangrid.plansensor;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends Activity {
    private static final int MAX_VALUES = 10;
    private Sensor sensor;
    private CompositeDisposable disposables = new CompositeDisposable();
    private LengthLimitedList<Integer> values;
    private Graph graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        graph = findViewById(R.id.graph);

        sensor = new Sensor();
        values = new LengthLimitedList<>(MAX_VALUES);
    }

    @Override
    protected void onResume() {
        super.onResume();
        disposables.add(sensor.getSensorObservable()
                              .observeOn(AndroidSchedulers.mainThread())
                              .subscribe(dataPoint -> {
                                  Log.v(getClass().getName(), "New Data Point: " + dataPoint.value);
                                  values.add(dataPoint.value);
                                  graph.setData(values);
                              }));
    }

    @Override
    protected void onPause() {
        disposables.clear();
        super.onPause();
    }

}
