package com.cs.lib_net.model

/**
 * Created by luyao
 * on 2018/3/13 14:38
 */
data class BaseTXApiModel<out T>(val code: Int, val msg: String, val newslist: T)