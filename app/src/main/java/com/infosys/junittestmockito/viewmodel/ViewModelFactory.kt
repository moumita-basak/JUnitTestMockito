package com.infosys.junittestmockito.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.infosys.junittestmockito.model.ItemRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: ItemRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ItemViewModel(repository) as T
    }
}