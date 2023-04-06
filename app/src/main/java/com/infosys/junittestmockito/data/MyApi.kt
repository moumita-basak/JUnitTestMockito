package com.infosys.junittestmockito.data

import com.infosys.junittestmockito.model.Items
import com.infosys.junittestmockito.util.CommonConstants
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit


interface MyApi {

    companion object{
    operator fun invoke(
        networkConnectionInterceptor: NetworkConnectionInterceptor
    ): MyApi{
        val okkHttpClient = OkHttpClient.Builder()
            .addInterceptor(networkConnectionInterceptor).readTimeout(600, TimeUnit.SECONDS)
            .connectTimeout(600, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okkHttpClient)
            .baseUrl(CommonConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MyApi::class.java)
    }

}
    @GET("codingtest/api/v1/festivals")
//    fun getItemData() : Observable<Items>
    fun getItemData() : Observable<Items>
}