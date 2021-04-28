package com.infosys.junittestmockito.data

import com.infosys.junittestmockito.model.Museum

/**
 * @author Eduardo Medina
 */
data class MuseumResponse(val status: Int?, val msg: String?, val data: List<Museum>?) {
    fun isSuccess(): Boolean = (status == 200)
}