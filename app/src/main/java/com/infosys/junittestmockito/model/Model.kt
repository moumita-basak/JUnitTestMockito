package com.infosys.junittestmockito.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName


data class ItemRow(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("imageHref")
    val imageHref: String)

@BindingAdapter("imageHref")
fun loadImage(view: ImageView, imageHref: String?) {
    Glide.with(view.context)
        .load(imageHref)
        .into(view)
}