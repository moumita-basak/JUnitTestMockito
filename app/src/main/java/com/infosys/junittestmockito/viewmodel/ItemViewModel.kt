package com.infosys.junittestmockito.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.infosys.junittestmockito.model.ItemRow
import com.infosys.junittestmockito.model.ItemRepository
import com.infosys.junittestmockito.model.Items
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ItemViewModel(private val repository: ItemRepository) : ViewModel() {
    private val _itemsResponse = MutableLiveData<List<ItemRow>>().apply { value = emptyList() }
    val itemResponse: LiveData<List<ItemRow>> = _itemsResponse

    var userResult: MutableLiveData<Items> = MutableLiveData()

    private val compositeDisposable = CompositeDisposable()

    fun getItemData() {
        repository.getItems().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                userResult.postValue(it)
                _itemsResponse.value = it.rows
            }, {

            }).let { compositeDisposable.add(it) }
    }

}