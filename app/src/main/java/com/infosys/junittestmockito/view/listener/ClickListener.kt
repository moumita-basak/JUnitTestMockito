package com.infosys.junittestmockito.view.listener

import com.infosys.junittestmockito.model.ItemRow

interface ClickListener {
    fun cardClicked(f: ItemRow?)

}