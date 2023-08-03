package com.pedronunes.propertiesapp.data.models

import com.google.gson.annotations.SerializedName


data class Facilities(

    @SerializedName("name") var name: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("facilities") var facilities: ArrayList<Facilities> = arrayListOf()
)