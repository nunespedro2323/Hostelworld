package com.pedronunes.propertiesapp.data.models

import com.google.gson.annotations.SerializedName


data class Properties(

    @SerializedName("properties") var properties: ArrayList<Property> = arrayListOf(),
    @SerializedName("location") var location: Location? = Location(),
    @SerializedName("locationEn") var locationEn: Location? = Location(),
    @SerializedName("filterData") var filterData: FilterData? = FilterData(),
    @SerializedName("sortOrder") var sortOrder: String? = null,
    @SerializedName("pagination") var pagination: Pagination? = Pagination()

)