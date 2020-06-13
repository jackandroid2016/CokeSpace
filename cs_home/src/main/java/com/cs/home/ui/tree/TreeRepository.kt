package com.cs.home.ui.tree

import com.cs.home.api.RequestCenter
import com.cs.home.model.tree.TreeData
import com.cs.lib_net.model.NetResult
import com.cs.lib_net.net.BaseRepository
import com.cs.lib_net.net.RetrofitClient

/**
 * Create by liwen on 2020-05-21
 */
class TreeRepository(private val service: RetrofitClient) : BaseRepository() {

    suspend fun getTreeList(): NetResult<MutableList<TreeData>> {
        return callRequest(call = { requestTreeList() })
    }

    private suspend fun requestTreeList() =
        handleResponse(service.create(0, RequestCenter::class.java).getTreeList())

}