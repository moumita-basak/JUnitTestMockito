package com.infosys.junittestmockito.data

import com.infosys.junittestmockito.model.ItemRow


data class ItemResponse(val status: Int?, val msg: String?, val data: List<ItemRow>?) {
    fun isSuccess(): Boolean = (status == 200)
}