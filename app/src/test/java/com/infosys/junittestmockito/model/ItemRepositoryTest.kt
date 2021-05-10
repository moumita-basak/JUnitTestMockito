package com.infosys.junittestmockito.model

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule

@RunWith(MockitoJUnitRunner::class)
class ItemRepositoryTest {


    private val repository = Mockito.mock(ItemRepository::class.java)

    @Rule
    @JvmField
    var instantTaskExecutorRule= InstantTaskExecutorRule()

    @Rule
    @JvmField
    var initRule: MockitoRule = MockitoJUnit.rule()
    private val application = Mockito.mock(Application::class.java)

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

 /*   @Test
    fun getAllItems() {
        Mockito.`when`(repository.getItems()).thenReturn(Observable.just(Items(emptyList(),"title")))
        assertEquals(Observable.just(Items(emptyList(),"title")),repository.getItems())
    }*/

    @Test
    fun getData() {
        Mockito.`when`(repository.getData()).thenReturn("hello")
        assertEquals("hello",repository.getData())
    }
}