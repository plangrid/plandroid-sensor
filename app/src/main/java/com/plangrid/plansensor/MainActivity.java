package com.plangrid.plansensor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final int MAX_VALUES = 10;
    private Sensor sensor;
    private CompositeDisposable disposables;
    private LengthLimitedList<Integer> values;

    @BindView(R.id.graph)
    Graph graph;

    // The graph view to populate with sensor data
    @BindView(R.id.graph)
    Graph graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sensor = new Sensor();
        values = new LengthLimitedList<>(MAX_VALUES);
    }

    @Override
    protected void onResume() {
        super.onResume();
        disposables = new CompositeDisposable();
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
        disposables.dispose();
        disposables = null;
        super.onPause();
    }

    @OnClick(R.id.record)
    protected void onClickRecord(View view) {
        // TODO: 9/14/17 Implement recording
    }

    @OnClick(R.id.play)
    protected void onClickPlay(View view) {
        // TODO: 9/14/17 Implement playback
    }
    
}
