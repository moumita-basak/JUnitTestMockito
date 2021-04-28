package com.infosys.junittestmockito.model

import com.google.gson.annotations.SerializedName

data class Items(
    val rows: MutableList<Museum>,
    @SerializedName("title")
    val title: String
)