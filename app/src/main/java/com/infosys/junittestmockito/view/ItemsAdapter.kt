package com.infosys.junittestmockito.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.infosys.junittestmockito.BR
import com.infosys.junittestmockito.R
import com.infosys.junittestmockito.databinding.ItemsBinding
import com.infosys.junittestmockito.model.ItemRow
import com.infosys.junittestmockito.view.listener.ClickListener


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
        holder.itemRowBinding.model = dataModel
        holder.bind(dataModel)
        holder.itemRowBinding.itemClickListener = this

    }

    override fun getItemCount(): Int {
        return dataModelList.size
    }

    inner class ViewHolder(var itemRowBinding: ItemsBinding) : RecyclerView.ViewHolder(itemRowBinding.root) {

        fun bind(obj: Any?) {
            itemRowBinding.setVariable(BR.model, obj)
            itemRowBinding.executePendingBindings()
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
