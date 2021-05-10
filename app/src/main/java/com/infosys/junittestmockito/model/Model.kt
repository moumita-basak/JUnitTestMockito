package com.infosys.junittestmockito.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author : Eduardo Medina
 * @since : 11/17/18
 * @see : https://developer.android.com/index.html
 */

data class ItemRow(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("imageHref")
    val imageHref: Any)


@BindingAdapter("imageHref")
fun loadImage(view: ImageView, imageHref: Any?) {
    Glide.with(view.getContext())
        .load(imageHref)
        .into(view)
}