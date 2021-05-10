package com.infosys.junittestmockito.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import android.util.Log.d
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.infosys.junittestmockito.data.ApiClient
import com.infosys.junittestmockito.data.ItemResponse
import com.infosys.junittestmockito.data.MyApi

import com.infosys.junittestmockito.data.OperationCallback
import com.infosys.junittestmockito.model.ItemRow
import com.infosys.junittestmockito.model.ItemRepository
import com.infosys.junittestmockito.model.Items
import com.infosys.junittestmockito.util.CommonConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Eduardo Medina
 */
class ItemViewModel( private val repository: ItemRepository) : ViewModel() {

    private val _items = MutableLiveData<List<ItemRow>>().apply { value = emptyList() }
    val items: LiveData<List<ItemRow>> = _items

    private val _itemsResponse = MutableLiveData<List<ItemRow>>().apply { value = emptyList() }
    val itemResponse: LiveData<List<ItemRow>> = _itemsResponse



    var retrofit: Retrofit? = null
    var userResult: MutableLiveData<Items> = MutableLiveData()
    private lateinit var disposableObserver: DisposableSingleObserver<Items>

    private val compositeDisposable = CompositeDisposable()
    fun userResult(): LiveData<Items> {
        return userResult
    }


   /* fun getItemData() {
        disposableObserver = object : DisposableSingleObserver<Items>() {
            override fun onSuccess(t: Items) {
                userResult.postValue(t)
                _itemsResponse.value = t.rows
            }
            override fun onError(e: Throwable) {

            }
        }
        repository.getItems()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(disposableObserver)
    }*/
    fun getItemData(){

       repository.getItems().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                userResult.postValue(it)
                    _itemsResponse.value = it.rows


            }, {

            }).let { compositeDisposable.add(it) }
    }


}