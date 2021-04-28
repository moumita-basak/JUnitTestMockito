package com.infosys.junittestmockito.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.infosys.junittestmockito.R
import com.infosys.junittestmockito.model.Museum

/**
 * @author Eduardo Medina
 */
class MuseumAdapter(private var museums: List<Museum>) :
    RecyclerView.Adapter<MuseumAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items, parent, false)
        return MViewHolder(view)
    }

    override fun onBindViewHolder(vh: MViewHolder, position: Int) {
        vh.bind(museums[position])
    }

    override fun getItemCount(): Int {
        return museums.size
    }

    fun update(data: List<Museum>) {
        museums = data
        notifyDataSetChanged()
    }

    class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var item_title: TextView = view.findViewById(R.id.item_title)
        var item_description: TextView = view.findViewById(R.id.item_description)
        var image_view: ImageView = view.findViewById(R.id.image_view)
        fun bind(museum: Museum) {
            val title = museum.title
            val description = museum.description
            val image = museum.imageHref

            try {
                if (!title.equals(null)){
                    item_title.text = title.toString()
                }
                if (!description.equals(null)) {
                    item_description.text = description.toString()
                }
                if (!image.equals(null)){
                    Glide.with(image_view.context).load(museum.imageHref).into(image_view)
                }

            }catch (ex:Exception){
                ex.printStackTrace()
            }
        }
    }
}