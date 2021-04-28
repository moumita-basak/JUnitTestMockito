package com.infosys.junittestmockito.model

import com.infosys.junittestmockito.data.OperationCallback


/**
 * @author Eduardo Medina
 */
interface MuseumDataSource {

    fun retrieveMuseums(callback: OperationCallback<Museum>)
    fun cancel()
}