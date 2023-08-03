package com.pedronunes.propertiesapp.data.models

import com.google.gson.annotations.SerializedName


data class Location(

    @SerializedName("city") var city: City? = City(),
    @SerializedName("region") var region: String? = null

)