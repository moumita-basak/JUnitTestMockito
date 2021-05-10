package com.infosys.junittestmockito.data

import com.google.gson.GsonBuilder
import com.infosys.junittestmockito.model.Items
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

/**
 * @author Eduardo Medina
 */
object ApiClient {

    var retrofit: Retrofit? = null

    //https://obscure-earth-55790.herokuapp.com/api/museums
    private const val API_BASE_URL = "https://dl.dropboxusercontent.com/"

    private var servicesApiInterface: ServicesApiInterface? = null



    fun build(): ServicesApiInterface? {
        var builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor())

        var retrofit: Retrofit = builder.client(httpClient.build()).build()
        servicesApiInterface = retrofit.create(ServicesApiInterface::class.java)

        return servicesApiInterface as ServicesApiInterface
    }

    private fun interceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

     fun callEndpoints() {
         val interceptor = HttpLoggingInterceptor()
         interceptor.level = HttpLoggingInterceptor.Level.BODY

         val okkHttpClient = OkHttpClient.Builder()
             .addInterceptor(interceptor).readTimeout(600, TimeUnit.SECONDS)
             .connectTimeout(600, TimeUnit.SECONDS)
             .build()
         val gson = GsonBuilder()
             .setLenient()
             .create()

         retrofit = Retrofit.Builder()
             .baseUrl(API_BASE_URL)
             .client(okkHttpClient)
             .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
             .addConverterFactory(GsonConverterFactory.create(gson))
             .build()
         val myAPi: ApiClient = retrofit!!.create(ApiClient::class.java)
     }

    interface ServicesApiInterface {
        @GET("s/2iodh4vg0eortkl/facts.json")
        fun items(): Call<ItemResponse>
    }

}