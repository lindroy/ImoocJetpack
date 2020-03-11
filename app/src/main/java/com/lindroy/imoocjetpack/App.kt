package com.lindroy.imoocjetpack

import android.app.Application
import com.lindroid.androidutilskt.app.AndUtil

/**
 * @author Lin
 * @date 2020/3/10
 * @function
 */
class App:Application() {
    override fun onCreate() {
        super.onCreate()
        AndUtil.init(this)
            .setLogGlobalConfig {  }
    }
}