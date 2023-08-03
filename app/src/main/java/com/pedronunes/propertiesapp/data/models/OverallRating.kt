package com.pedronunes.propertiesapp.data.models

import com.google.gson.annotations.SerializedName
import com.pedronunes.propertiesapp.util.getRatingValueString


data class OverallRating(

    @SerializedName("overall") var overall: Double? = null,
    @SerializedName("numberOfRatings") var numberOfRatings: String? = null

) {
    fun getOverallRatingString() = overall?.getRatingValueString()
}