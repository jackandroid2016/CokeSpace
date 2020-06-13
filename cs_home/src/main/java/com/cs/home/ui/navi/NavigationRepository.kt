package com.cs.home.ui.navi

import com.cs.home.api.RequestCenter
import com.cs.home.model.navigation.NavigationItem
import com.cs.lib_net.model.NetResult
import com.cs.lib_net.net.BaseRepository
import com.cs.lib_net.net.RetrofitClient

/**
 * Create by liwen on 2020/5/28
 */
class NavigationRepository(private val service: RetrofitClient) : BaseRepository() {

    suspend fun getNavigationData(): NetResult<MutableList<NavigationItem>> {
        return callRequest(call = { requestNavigationData() })
    }

    private suspend fun requestNavigationData(): NetResult<MutableList<NavigationItem>> =
        handleResponse(service.create(0, RequestCenter::class.java).getNavigationData())

}