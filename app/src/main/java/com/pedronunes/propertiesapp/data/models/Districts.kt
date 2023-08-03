package com.pedronunes.propertiesapp.data.models

import com.google.gson.annotations.SerializedName


data class Districts(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null

)