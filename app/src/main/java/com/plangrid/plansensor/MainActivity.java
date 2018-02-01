package com.plangrid.plansensor;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {
    private CompositeDisposable disposables = new CompositeDisposable();
    @BindView(R.id.graph)
    Graph graph;

    @BindView(R.id.record)
    protected Button record;

    @BindView(R.id.play)
    protected Button play;

    private GraphViewModel graphViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        graphViewModel = ViewModelProviders.of(this).get(GraphViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        disposables.add(graphViewModel.getGraphData().subscribe(dataPoints -> graph.setData(dataPoints)));
        disposables.add(graphViewModel.getState().observeOn(AndroidSchedulers.mainThread()).subscribe(sensorState -> {
            switch(sensorState) {
                case LIVE:
                    record.setEnabled(true);
                    play.setEnabled(true);
                    break;
                case PLAYING:
                    record.setEnabled(false);
                    play.setEnabled(false);
                    break;
                case RECORDING:
                    record.setEnabled(true);
                    play.setEnabled(false);
                    break;
            }
        }));
    }

    @Override
    protected void onPause() {
        disposables.clear();
        super.onPause();
    }

    @OnClick(R.id.record)
    protected void onClickRecord(View view) {
        graphViewModel.toggleRecording();
    }

    @OnClick(R.id.play)
    protected void onClickPlay(View view) {
        graphViewModel.playRecording();
    }
}
