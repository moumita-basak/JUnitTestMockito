package com.infosys.junittestmockito.model

import com.google.gson.annotations.SerializedName

data class Items(
    val rows: List<ItemRow>,
    @SerializedName("title")
    val title: String
)