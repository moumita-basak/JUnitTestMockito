package com.infosys.junittestmockito.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule

@Suppress("DEPRECATION")
@RunWith(MockitoJUnitRunner::class)
class ItemRepositoryTest {


    private val repository = mock(ItemRepository::class.java)

    @Rule
    @JvmField
    var instantTaskExecutorRule= InstantTaskExecutorRule()

    @Rule
    @JvmField
    var initRule: MockitoRule = MockitoJUnit.rule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun getData() {
        Mockito.`when`(repository.getData()).thenReturn("hello")
        assertEquals("hello",repository.getData())
    }
}