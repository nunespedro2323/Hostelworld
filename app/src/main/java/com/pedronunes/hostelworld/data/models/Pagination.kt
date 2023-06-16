package com.pedronunes.hostelworld.data.models

import com.google.gson.annotations.SerializedName


data class Pagination(

    @SerializedName("next") var next: String? = null,
    @SerializedName("prev") var prev: String? = null,
    @SerializedName("numberOfPages") var numberOfPages: Int? = null,
    @SerializedName("totalNumberOfItems") var totalNumberOfItems: Int? = null

)