package com.cokespace.zl

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.tencent.mmkv.MMKV
import com.cs.lib_base.utils.BaseContext
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CokeSpaceApp : Application() {
    override fun onCreate() {
        super.onCreate()

        BaseContext.instance.init(this)
        ARouter.init(this)
        MMKV.initialize(this)

        startKoin {
            androidContext(this@CokeSpaceApp)
            modules(allModule)
        }
    }
}