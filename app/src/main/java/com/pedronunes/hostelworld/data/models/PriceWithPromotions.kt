package com.pedronunes.hostelworld.data.models

import com.google.gson.annotations.SerializedName
import com.pedronunes.hostelworld.util.getPriceValueString


data class PriceWithPromotions(

    @SerializedName("value") var value: Double? = null,
    @SerializedName("currency") var currency: String? = null,
    @SerializedName("promotions") var promotions: PromotionsUsed? = PromotionsUsed(),
    @SerializedName("original") var original: Double? = null

) {
    fun getValueString() = value?.getPriceValueString()

    fun getValueVisibility() = !getValueString().isNullOrEmpty()

    fun getOriginalValueString() = original?.getPriceValueString()

    fun getOriginalValueVisibility() = !getOriginalValueString().isNullOrEmpty()
}