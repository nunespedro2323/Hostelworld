package com.pedronunes.propertiesapp.data.models

import com.google.gson.annotations.SerializedName


data class Distance(

    @SerializedName("value") var value: Double? = null,
    @SerializedName("units") var units: String? = null

)