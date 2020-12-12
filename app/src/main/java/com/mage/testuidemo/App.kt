package com.mage.testuidemo

import android.app.Application

/**
 * author  :mayong
 * function:
 * date    :2020/12/12
 **/
class App : Application() {

    companion object {
        lateinit var application: App

    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }

}