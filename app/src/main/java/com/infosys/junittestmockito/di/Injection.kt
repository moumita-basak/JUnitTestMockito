package com.infosys.junittestmockito.di

import androidx.lifecycle.ViewModelProvider

import com.infosys.junittestmockito.data.ApiClient
import com.infosys.junittestmockito.data.MuseumRemoteDataSource
import com.infosys.junittestmockito.model.MuseumDataSource
import com.infosys.junittestmockito.model.MuseumRepository
import com.infosys.junittestmockito.viewmodel.ViewModelFactory

/**
 * @author Eduardo Medina
 */
object Injection {

    private val museumDataSource: MuseumDataSource = MuseumRemoteDataSource(ApiClient)
    private val museumRepository = MuseumRepository(museumDataSource)
    private val museumViewModelFactory = ViewModelFactory(museumRepository)

    fun providerRepository(): MuseumDataSource {
        return museumDataSource
    }

    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return museumViewModelFactory
    }
}