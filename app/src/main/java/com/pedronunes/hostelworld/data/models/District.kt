package com.pedronunes.hostelworld.data.models

import com.google.gson.annotations.SerializedName


data class District(

    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null

)