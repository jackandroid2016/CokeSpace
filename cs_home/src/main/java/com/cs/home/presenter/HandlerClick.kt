package com.cs.home.presenter

import android.content.Context
import com.cs.lib_base.service.webview.warp.WebViewWarpService

/**
 * Create by liwen on 2020/5/27
 */
object HandlerClick {

    fun navigationItemClick(context: Context, title: String, url: String) {
        WebViewWarpService.instance.start(context, title, url)
    }

}