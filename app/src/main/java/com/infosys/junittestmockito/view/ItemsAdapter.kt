package com.infosys.junittestmockito.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.infosys.junittestmockito.BR
import com.infosys.junittestmockito.R
import com.infosys.junittestmockito.databinding.ItemsBinding
import com.infosys.junittestmockito.model.ItemRow
import com.infosys.junittestmockito.view.listener.ClickListener

/**
 * @author Eduardo Medina
 */
    class ItemsAdapter(dataModelList: List<ItemRow>, ctx: Context)
    : RecyclerView.Adapter<ItemsAdapter.ViewHolder?>(), ClickListener {
        private var dataModelList: List<ItemRow>
    private val context: Context
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
    val binding:ItemsBinding = DataBindingUtil.inflate( LayoutInflater.from(parent.context),
        R.layout.items, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel: ItemRow = dataModelList[position]
        holder.itemRowBinding.setModel(dataModel)
        holder.bind(dataModel)
        holder.itemRowBinding.itemClickListener = this


    }

    override fun getItemCount(): Int {
        return dataModelList.size
    }

    inner class ViewHolder(itemRowBinding: ItemsBinding) : RecyclerView.ViewHolder(itemRowBinding.root) {

        var itemRowBinding: ItemsBinding

        fun bind(obj: Any?) {
            itemRowBinding.setVariable(BR.model, obj)
            itemRowBinding.executePendingBindings()
        }

        init {
            this.itemRowBinding = itemRowBinding
        }
    }

    init {
        this.dataModelList = dataModelList
        context = ctx
    }


    override fun cardClicked(f: ItemRow?) {

    }
    fun update(data: List<ItemRow>) {
        dataModelList = data
        notifyDataSetChanged()
    }
}
   /* override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items, parent, false)
        return MViewHolder(view)
    }

    override fun onBindViewHolder(vh: MViewHolder, position: Int) {
        vh.bind(itemsList[position])
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }*/



   /* class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var item_title: TextView = view.findViewById(R.id.item_title)
        var item_description: TextView = view.findViewById(R.id.item_description)
        var image_view: ImageView = view.findViewById(R.id.image_view)
        fun bind(itemRow: ItemRow) {
            val title = itemRow.title
            val description = itemRow.description
            val image = itemRow.imageHref

            try {
                if (!title.equals(null)){
                    item_title.text = title.toString()
                }
                if (!description.equals(null)) {
                    item_description.text = description.toString()
                }
                if (!image.equals(null)){
                    Glide.with(image_view.context).load(itemRow.imageHref).into(image_view)
                }

            }catch (ex:Exception){
                ex.printStackTrace()
            }
        }
    }*/
