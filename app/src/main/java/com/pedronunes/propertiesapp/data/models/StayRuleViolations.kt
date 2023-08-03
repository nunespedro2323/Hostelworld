package com.pedronunes.propertiesapp.data.models

import com.google.gson.annotations.SerializedName


data class StayRuleViolations(

    @SerializedName("description") var description: String? = null

)