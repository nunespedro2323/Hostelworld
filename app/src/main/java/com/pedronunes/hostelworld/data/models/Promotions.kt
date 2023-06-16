package com.pedronunes.hostelworld.data.models

import com.google.gson.annotations.SerializedName


data class Promotions(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("stack") var stack: Boolean? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("discount") var discount: Int? = null

)