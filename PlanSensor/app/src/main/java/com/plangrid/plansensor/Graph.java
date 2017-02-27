package com.plangrid.plansensor;

import android.content.Context;
import android.util.AttributeSet;

import com.robinhood.spark.SparkAdapter;
import com.robinhood.spark.SparkView;

public class Graph extends SparkView {
    private int[] data = new int[]{};
    private final SparkAdapter adapter = new GraphAdapter();

    public Graph(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAdapter(adapter);
    }

    /**
     * Set the data for the graph to display
     *
     * @param data - An int[] containing all the datapoints the graph should display
     */
    public void setData(int[] data) {
        this.data = data;
        adapter.notifyDataSetChanged();
    }

    private class GraphAdapter extends SparkAdapter {

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int index) {
            return data[index];
        }

        @Override
        public float getY(int index) {
            return data[index];
        }
    }

}
