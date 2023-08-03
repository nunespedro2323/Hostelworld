package com.pedronunes.propertiesapp.data.models

import com.google.gson.annotations.SerializedName
import com.pedronunes.propertiesapp.util.getPriceValueString


data class Price(

    @SerializedName("value") var value: Double? = null,
    @SerializedName("currency") var currency: String? = null

) {
    fun getValueString() = value?.getPriceValueString()

    fun getValueVisibility() = !getValueString().isNullOrEmpty()

}