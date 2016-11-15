package com.plangrid.plansensor;

import android.content.Context;
import android.util.AttributeSet;

import com.robinhood.spark.SparkAdapter;
import com.robinhood.spark.SparkView;

public class Graph extends SparkView {
    int[] data = new int[]{};
    SparkAdapter adapter = new GraphAdapter();

    public Graph(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAdapter(adapter);
    }

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
