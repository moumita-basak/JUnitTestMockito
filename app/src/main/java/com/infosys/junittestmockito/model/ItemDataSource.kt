package com.infosys.junittestmockito.model

import com.infosys.junittestmockito.data.OperationCallback


interface ItemDataSource {

    fun retrieveItems(callback: OperationCallback<ItemRow>)
    fun cancel()


}