package com.infosys.junittestmockito

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.infosys.junittestmockito.data.MyApi
import com.infosys.junittestmockito.data.OperationCallback
import com.infosys.junittestmockito.model.ItemRow
import com.infosys.junittestmockito.model.ItemDataSource
import com.infosys.junittestmockito.model.ItemRepository
import com.infosys.junittestmockito.viewmodel.ItemViewModel

import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.*
import org.mockito.Mockito.*

/**
 * @author Eduardo Medina
 */
class ItemViewModelTest {

    @Mock
    private lateinit var itemDataSource: ItemDataSource

    @Mock
    private lateinit var context: Application

    @Captor
    private lateinit var operationCallbackCaptor: ArgumentCaptor<OperationCallback<ItemRow>>

    private lateinit var viewModel: ItemViewModel
    private lateinit var repository: ItemRepository
    private lateinit var myApi: MyApi

    private lateinit var isViewLoadingObserver: Observer<Boolean>
    private lateinit var onMessageErrorObserver: Observer<Any>
    private lateinit var emptyListObserver: Observer<Boolean>
    private lateinit var onRenderItemsObserver: Observer<List<ItemRow>>

    private lateinit var itemEmptyList: List<ItemRow>
    private lateinit var itemList: List<ItemRow>


    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        `when`(context.applicationContext).thenReturn(context)

        repository = ItemRepository(myApi)
        viewModel = ItemViewModel(repository)

        mockData()
        setupObservers()
    }

/*
    fun `retrieve items with ViewModel and Repository returns empty data`() {
        with(viewModel) {

            callItemList()
            isViewLoading.observeForever(isViewLoadingObserver)
            isEmptyList.observeForever(emptyListObserver)
            itemResponse.observeForever(onRenderItemsObserver)
        }

        verify(itemDataSource, times(1)).retrieveItems(capture(operationCallbackCaptor))
        operationCallbackCaptor.value.onSuccess(itemEmptyList)


        Assert.assertNotNull(viewModel.isViewLoading.value)
        Assert.assertTrue(viewModel.isEmptyList.value == true)
//        Assert.assertTrue(viewModel.items.value?.size == 0)
        Assert.assertTrue(viewModel.itemResponse.value?.size == 0)
    }
*/

/*
    fun `retrieve items with ViewModel and Repository returns full data`() {
        with(viewModel) {

            callItemList()
            isViewLoading.observeForever(isViewLoadingObserver)
//            items.observeForever(onRenderItemsObserver)
            itemResponse.observeForever(onRenderItemsObserver)
        }

        verify(itemDataSource, times(1)).retrieveItems(capture(operationCallbackCaptor))
        operationCallbackCaptor.value.onSuccess(itemList)

        Assert.assertNotNull(viewModel.isViewLoading.value)
//        Assert.assertTrue(viewModel.items.value?.size == 3)
        Assert.assertTrue(viewModel.itemResponse.value?.size == 3)
    }
*/


/*
    fun `retrieve items with ViewModel and Repository returns an error`() {
        with(viewModel) {
//            loadItems()
//            callEndpoints()
            callItemList()
            isViewLoading.observeForever(isViewLoadingObserver)
            onMessageError.observeForever(onMessageErrorObserver)
        }
        verify(itemDataSource, times(1)).retrieveItems(capture(operationCallbackCaptor))
        operationCallbackCaptor.value.onError("An error occurred")
        Assert.assertNotNull(viewModel.isViewLoading.value)
        Assert.assertNotNull(viewModel.onMessageError.value)
    }
*/

    private fun setupObservers() {
        isViewLoadingObserver = mock(Observer::class.java) as Observer<Boolean>
        onMessageErrorObserver = mock(Observer::class.java) as Observer<Any>
        emptyListObserver = mock(Observer::class.java) as Observer<Boolean>
        onRenderItemsObserver = mock(Observer::class.java) as Observer<List<ItemRow>>
    }

    private fun mockData() {
        itemEmptyList = emptyList()
        val mockList: MutableList<ItemRow> = mutableListOf()
        mockList.add(
            ItemRow("Title 1",
                "Museo Nacional de Arqueología, Antropología e Historia del Perú",
                ""
            )
        )
        mockList.add(ItemRow("Title 2", "Museo de Sitio Pachacamac", ""))
        mockList.add(ItemRow("Title 3", "Casa Museo José Carlos Mariátegui", ""))

        itemList = mockList.toList()
    }
}