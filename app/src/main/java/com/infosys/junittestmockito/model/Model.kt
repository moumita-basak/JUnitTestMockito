package com.infosys.junittestmockito.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author : Eduardo Medina
 * @since : 11/17/18
 * @see : https://developer.android.com/index.html
 */

data class Museum(
    @SerializedName("title")
    val title: Any,
    @SerializedName("description")
    val description: Any,
    @SerializedName("imageHref")
    val imageHref: Any

)