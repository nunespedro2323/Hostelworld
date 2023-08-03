package com.pedronunes.propertiesapp.data.models

import com.google.gson.annotations.SerializedName


data class FilterData(

    @SerializedName("highestPricePerNight") var highestPricePerNight: Price? = Price(),
    @SerializedName("lowestPricePerNight") var lowestPricePerNight: Price? = Price()

)