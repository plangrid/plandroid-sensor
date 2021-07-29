package com.plangrid.plansensor

import android.content.Context
import android.util.AttributeSet
import com.robinhood.spark.SparkAdapter
import com.robinhood.spark.SparkView
import java.util.*

class GraphView(context: Context?, attrs: AttributeSet?) :
    SparkView(context, attrs) {
    private var data: List<Int> = ArrayList()

    override fun getAdapter(): SparkAdapter = GraphAdapter()

    /**
     * Set the data for the graph to display
     *
     * @param data - A List<Integer> containing all the data points the graph should display
    </Integer> */
    fun setData(data: List<Int>) {
        this.data = data
        adapter.notifyDataSetChanged()
    }

    private inner class GraphAdapter : SparkAdapter() {
        override fun getCount(): Int = data.size

        override fun getItem(index: Int): Any {
            return data[index]
        }

        override fun getY(index: Int): Float {
            return data[index].toFloat()
        }
    }

    init {
        setAdapter(adapter)
    }
}
