package com.pedronunes.hostelworld.data.models

import com.google.gson.annotations.SerializedName


data class Images(

    @SerializedName("prefix") var prefix: String? = null,
    @SerializedName("suffix") var suffix: String? = null

)