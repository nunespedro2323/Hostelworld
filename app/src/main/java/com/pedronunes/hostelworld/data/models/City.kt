package com.pedronunes.hostelworld.data.models

import com.google.gson.annotations.SerializedName


data class City(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("idCountry") var idCountry: Int? = null,
    @SerializedName("country") var country: String? = null

)