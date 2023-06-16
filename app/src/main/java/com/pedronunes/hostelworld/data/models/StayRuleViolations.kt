package com.pedronunes.hostelworld.data.models

import com.google.gson.annotations.SerializedName


data class StayRuleViolations(

    @SerializedName("description") var description: String? = null

)