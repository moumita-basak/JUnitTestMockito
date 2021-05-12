package com.infosys.junittestmockito

import android.app.Application
import android.content.Context
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware


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

    }
}