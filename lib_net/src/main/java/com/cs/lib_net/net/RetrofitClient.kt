package com.cs.lib_net.net


import com.cs.lib_net.BuildConfig
import com.cs.lib_net.interceptor.CommonInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient private constructor() {

    private var retrofit: Retrofit
    private var wanAndroidUrl = "https://www.wanandroid.com"
    private val tXUrl = "http://api.tianapi.com"
    private val rollToolsApiUrl = "https://www.mxnzp.com/api"
    private val videoUrl = "https://api.apiopen.top"
    private var baseUrl = wanAndroidUrl;

    companion object {
        val instance: RetrofitClient by lazy { RetrofitClient() }
    }

    init {

        retrofit = Retrofit.Builder()
            .client(initClient())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

    }

    private fun initClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(initLogInterceptor())
            .addInterceptor(CommonInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    private fun initLogInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        }
        return loggingInterceptor
    }


    fun <T> create(base: Int, service: Class<T>): T {
        when (base) {
            0 -> baseUrl = wanAndroidUrl
            1 -> baseUrl = tXUrl
            2 -> baseUrl = rollToolsApiUrl
            3 -> baseUrl = videoUrl
            else -> {
                baseUrl = wanAndroidUrl
            }
        }
        retrofit = Retrofit.Builder()
            .client(initClient())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
        return retrofit.create(service)
    }


}