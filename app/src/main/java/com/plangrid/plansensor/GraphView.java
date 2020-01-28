package com.plangrid.plansensor;

import android.content.Context;
import android.util.AttributeSet;

import com.robinhood.spark.SparkAdapter;
import com.robinhood.spark.SparkView;

import java.util.ArrayList;
import java.util.List;

public class GraphView extends SparkView {
    private List<Integer> data = new ArrayList<>();
    private final SparkAdapter adapter = new GraphAdapter();

    public GraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAdapter(adapter);
    }

    /**
     * Set the data for the graph to display
     *
     * @param data - A List<Integer> containing all the data points the graph should display
     */
    public void setData(List<Integer> data) {
        this.data = data;
        adapter.notifyDataSetChanged();
    }

    private class GraphAdapter extends SparkAdapter {

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int index) {
            return data.get(index);
        }

        @Override
        public float getY(int index) {
            return data.get(index);
        }
    }

}
