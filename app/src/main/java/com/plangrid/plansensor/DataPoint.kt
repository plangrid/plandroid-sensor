package com.plangrid.plansensor

import com.google.gson.annotations.SerializedName

data class DataPoint(@SerializedName("value") val value: Int)
