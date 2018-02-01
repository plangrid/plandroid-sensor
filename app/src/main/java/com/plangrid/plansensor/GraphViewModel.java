package com.plangrid.plansensor;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;

public class GraphViewModel extends ViewModel {
    private static final int MAX_VALUES = 10;

    private LengthLimitedList<Integer> values = new LengthLimitedList<>(MAX_VALUES);
    private List<Integer> recordedValues = new ArrayList<>();

    private Sensor sensor = new Sensor();
    private BehaviorSubject<List<Integer>> graphData = BehaviorSubject.create();
    private BehaviorSubject<SensorState> state = BehaviorSubject.create();
    private boolean isRecording = false;

    private CompositeDisposable subscriptions = new CompositeDisposable();

    public GraphViewModel() {
        playLiveData();
    }

    public Observable<List<Integer>> getGraphData() {
        return graphData;
    }

    public Observable<SensorState> getState() {
        return state;
    }

    public void toggleRecording() {
        if (!isRecording) {
            recordedValues.clear();
            state.onNext(SensorState.RECORDING);
        } else {
            state.onNext(SensorState.LIVE);
        }

        isRecording = !isRecording;
    }

    public void playRecording() {
        subscriptions.clear();
        isRecording = false;
        state.onNext(SensorState.PLAYING);

        Observable.interval(1, TimeUnit.SECONDS).take(recordedValues.size()).subscribe(aLong -> {
            graphData.onNext(recordedValues.subList(0, aLong.intValue()));
        }, throwable -> {
            //ERROR
        }, () -> {
            values.clear();
            playLiveData();
        });
    }

    public void playLiveData() {
        state.onNext(SensorState.LIVE);
        subscriptions.add(sensor.getSensorObservable()
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(dataPoint -> {
                                    Log.v(getClass().getName(), "New Data Point: " + dataPoint.value);
                                    values.add(dataPoint.value);
                                    if (isRecording) {
                                        recordedValues.add(dataPoint.value);
                                    }
                                    graphData.onNext(values);
                                }));
    }
}
