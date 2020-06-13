package com.cs.home.ui.home

import com.cs.home.api.RequestCenter
import com.cs.home.model.home.Banner
import com.cs.home.model.home.DataFeed
import com.cs.home.model.home.Weather
import com.cs.lib_net.model.NetResult
import com.cs.lib_net.net.BaseRepository
import com.cs.lib_net.net.RetrofitClient

/**
 * Create by liwen on 2020-05-18
 */
class HomeRepository(private val service: RetrofitClient) : BaseRepository() {

    suspend fun getBanner(): NetResult<List<Banner>> {
        return callRequest(call = { requestBanner() })
    }

    suspend fun getWeather(key: String, city: String): NetResult<List<Weather>> {
        return callRequest(call = { requestWeather(key, city) })
    }

    suspend fun getHomeList(key: String, num: Int, page: Int): NetResult<List<DataFeed>> {
        return callRequest(call = { requestHomeList(key, num, page) })
    }

    private suspend fun requestBanner() =
        handleResponse(service.create(0, RequestCenter::class.java).getBanner())

    private suspend fun requestWeather(key: String, city: String) =
        handleTXApiResponse(service.create(1, RequestCenter::class.java).getWeather(key, city))

    private suspend fun requestHomeList(key: String, num: Int, page: Int) =
        handleTXApiResponse(
            service.create(1, RequestCenter::class.java).getITNewsList(key, num, page)
        )


}