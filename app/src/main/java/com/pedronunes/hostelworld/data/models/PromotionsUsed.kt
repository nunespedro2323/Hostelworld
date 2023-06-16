package com.pedronunes.hostelworld.data.models

import com.google.gson.annotations.SerializedName


data class PromotionsUsed(

    @SerializedName("promotionsIds") var promotionsIds: ArrayList<Int> = arrayListOf(),
    @SerializedName("totalDiscount") var totalDiscount: String? = null

)