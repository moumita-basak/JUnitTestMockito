package com.infosys.junittestmockito.model

import com.infosys.junittestmockito.data.OperationCallback


/**
 * @author Eduardo Medina
 */
class MuseumRepository(private val museumDataSource: MuseumDataSource) {

    fun fetchMuseums(callback: OperationCallback<Museum>) {
        museumDataSource.retrieveMuseums(callback)
    }

    fun cancel() {
        museumDataSource.cancel()
    }
}