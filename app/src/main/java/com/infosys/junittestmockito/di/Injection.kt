package com.infosys.junittestmockito.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.infosys.junittestmockito.JunitTestMockitoApplication

import com.infosys.junittestmockito.data.ApiClient
import com.infosys.junittestmockito.data.ItemRemoteDataSource
import com.infosys.junittestmockito.data.MyApi
import com.infosys.junittestmockito.data.NetworkConnectionInterceptor
import com.infosys.junittestmockito.model.ItemDataSource
import com.infosys.junittestmockito.model.ItemRepository
import com.infosys.junittestmockito.viewmodel.ViewModelFactory

/**
 * @author Eduardo Medina
 */
object Injection {

    private val itemDataSource: ItemDataSource = ItemRemoteDataSource(ApiClient)
    private val myApi: MyApi = MyApi(NetworkConnectionInterceptor(JunitTestMockitoApplication.appContext!!))
    private val itemRepository = ItemRepository(myApi)
    private val itemViewModelFactory = ViewModelFactory(itemRepository)

    fun providerRepository(): ItemDataSource {
        return itemDataSource
    }

    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return itemViewModelFactory
    }
}