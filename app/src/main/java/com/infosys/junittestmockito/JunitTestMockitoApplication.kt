package com.infosys.junittestmockito

import android.app.Application
import android.content.Context
import com.infosys.junittestmockito.data.MyApi
import com.infosys.junittestmockito.data.NetworkConnectionInterceptor
import com.infosys.junittestmockito.model.ItemRepository
import com.infosys.junittestmockito.viewmodel.ViewModelFactory
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


class JunitTestMockitoApplication : Application(), KodeinAware {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        Logger.addLogAdapter(AndroidLogAdapter())

    }

    companion object {
        var appContext: Context? = null
            private set
    }
    override val kodein = Kodein.lazy {
        import(androidXModule(this@JunitTestMockitoApplication))
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }

        bind() from provider { ViewModelFactory(instance()) }
        bind() from singleton { ItemRepository(instance()) }
    }
}