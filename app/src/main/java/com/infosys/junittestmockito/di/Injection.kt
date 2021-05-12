package com.infosys.junittestmockito.di

import androidx.lifecycle.ViewModelProvider
import com.infosys.junittestmockito.JunitTestMockitoApplication
import com.infosys.junittestmockito.data.MyApi
import com.infosys.junittestmockito.data.NetworkConnectionInterceptor
import com.infosys.junittestmockito.model.ItemRepository
import com.infosys.junittestmockito.viewmodel.ViewModelFactory


object Injection {

    private val myApi: MyApi =
        MyApi(NetworkConnectionInterceptor(JunitTestMockitoApplication.appContext!!))
    private val itemRepository = ItemRepository(myApi)
    private val itemViewModelFactory = ViewModelFactory(itemRepository)

    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return itemViewModelFactory
    }
}