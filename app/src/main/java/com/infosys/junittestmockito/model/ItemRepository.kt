package com.infosys.junittestmockito.model

import android.content.ClipData
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.infosys.junittestmockito.data.MyApi
import com.infosys.junittestmockito.data.OperationCallback
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import java.net.URL
import java.util.*


/**
 * @author Eduardo Medina
 */
 class ItemRepository( private val myApi: MyApi) {


   public fun getAllItems (): Single<Items> {
        return Single.create<Items>{
          val json = URL("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json").readText()
            val itemsList = Gson().fromJson(json, Items::class.java)
          it.onSuccess(itemsList)
        }
    }
    public fun getData():String{
        return "hello"
    }

     public fun getItems() = myApi.getItemData()




}
