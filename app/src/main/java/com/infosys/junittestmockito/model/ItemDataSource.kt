package com.infosys.junittestmockito.model

import com.infosys.junittestmockito.data.OperationCallback
import io.reactivex.Single


/**
 * @author Eduardo Medina
 */
interface ItemDataSource {

    fun retrieveItems(callback: OperationCallback<ItemRow>)
    fun cancel()


}