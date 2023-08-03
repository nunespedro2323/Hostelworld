package com.pedronunes.propertiesapp.data.models

import com.google.gson.annotations.SerializedName


data class RatingBreakdown(

    @SerializedName("ratingsCount") var ratingsCount: Int? = null,
    @SerializedName("security") var security: Int? = null,
    @SerializedName("location") var location: Int? = null,
    @SerializedName("staff") var staff: Int? = null,
    @SerializedName("fun") var funny: Int? = null,
    @SerializedName("clean") var clean: Int? = null,
    @SerializedName("facilities") var facilities: Int? = null,
    @SerializedName("value") var value: Int? = null,
    @SerializedName("average") var average: Int? = null

)