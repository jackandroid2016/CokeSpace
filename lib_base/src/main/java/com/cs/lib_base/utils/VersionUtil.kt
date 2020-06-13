package com.cs.lib_base.utils

import android.annotation.SuppressLint

object VersionUtil {

    @JvmStatic
    fun getVersionName(): String {
        val context = BaseContext.instance.getContext();
        val packageManager = context.packageManager
        // 0表示获取基本数据
        val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
        return packageInfo.versionName;
    }

    @JvmStatic
    @SuppressLint("NewApi")
    fun getVersionCode(): Long {
        val context = BaseContext.instance.getContext();
        val packageManager = context.packageManager
        // 0表示获取基本数据
        val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
        return packageInfo.longVersionCode;
    }
}