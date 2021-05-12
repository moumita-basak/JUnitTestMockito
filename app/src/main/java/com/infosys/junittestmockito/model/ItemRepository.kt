package com.infosys.junittestmockito.model

import com.infosys.junittestmockito.data.MyApi

class ItemRepository(private val myApi: MyApi) {

    fun getData(): String {
        return "hello"
    }

    fun getItems() = myApi.getItemData()
}
