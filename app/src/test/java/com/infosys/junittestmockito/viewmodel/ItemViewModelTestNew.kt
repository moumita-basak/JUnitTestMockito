package com.infosys.junittestmockito.viewmodel

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.infosys.junittestmockito.data.MyApi
import com.infosys.junittestmockito.data.NetworkConnectionInterceptor
import com.infosys.junittestmockito.model.ItemRepository
import com.infosys.junittestmockito.model.ItemRow
import com.infosys.junittestmockito.model.Items
import io.reactivex.Observable
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

@Suppress("DEPRECATION")
class ItemViewModelTestNew{
    @Mock
    private lateinit var context: Application
    @Mock
    lateinit var observer: Observer<Items>
    private lateinit var viewModel: ItemViewModel

    private lateinit var myApi: MyApi

    private lateinit var itemList: List<ItemRow>
    private lateinit var itemEmptyList: List<ItemRow>
    private val repository = mock(ItemRepository::class.java)




    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        myApi = MyApi(NetworkConnectionInterceptor(context))
        viewModel = ItemViewModel(repository)
        mockData()

    }
    @Test
    fun `retrieve items with ViewModel and Repository returns empty data`() {
        itemList = ArrayList<ItemRow>()
        val items = Items(itemList,name = "name")
        Mockito.`when`(repository.getItems()).thenReturn(Observable.just(items))
        viewModel.userResult.observeForever(observer)
        viewModel.getItemData()
        assert(viewModel.itemResponse.value == items.bands)

    }
    @Test
    fun `retrieve items with ViewModel and Repository returns  data`() {
        val items = Items(itemList,name = "name")
        Mockito.`when`(repository.getItems()).thenReturn(Observable.just(items))
        viewModel.userResult.observeForever(observer)
       assertTrue(viewModel.itemResponse.value!!.isEmpty())


    }

    private fun mockData() {
        val mockList: MutableList<ItemRow> = mutableListOf()
        mockList.add(
            ItemRow("Title 1",
                "Museo Nacional de Arqueología, Antropología e Historia del Perú"
            )
        )
        mockList.add(ItemRow("Title 2", "Museo de Sitio Pachacamac"))
        mockList.add(ItemRow("Title 3", "Casa Museo José Carlos Mariátegui"))

        itemList = mockList.toList()
    }


    @Test
    fun itemListEmpty(){
        itemList = ArrayList()

    }

}
