package com.pedronunes.propertiesapp.data.models

import com.google.gson.annotations.SerializedName


data class FreeCancellation(

    @SerializedName("label") var label: String? = null,
    @SerializedName("description") var description: String? = null

)