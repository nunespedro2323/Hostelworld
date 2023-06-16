package com.pedronunes.hostelworld.data.models

import com.google.gson.annotations.SerializedName


data class FabSort(

    @SerializedName("rank1") var rank1: Int? = null,
    @SerializedName("rank2") var rank2: Int? = null,
    @SerializedName("rank3") var rank3: Int? = null,
    @SerializedName("rank4") var rank4: Int? = null,
    @SerializedName("rank5") var rank5: Int? = null,
    @SerializedName("rank6") var rank6: Int? = null,
    @SerializedName("rank7") var rank7: Int? = null,
    @SerializedName("rank8") var rank8: Int? = null,
    @SerializedName("rank9") var rank9: Int? = null

)