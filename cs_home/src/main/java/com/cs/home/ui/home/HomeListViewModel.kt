package com.cs.home.ui.home

import android.widget.Toast
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.cs.home.model.home.DataFeed
import com.cs.lib_base.base.AbsListViewModel
import com.cs.lib_base.utils.BaseContext
import com.cs.lib_net.model.NetResult
import kotlinx.coroutines.launch
import java.util.*

/**
 * Create by liwen on 2020/6/4
 */
class HomeListViewModel(private val repository: HomeRepository) : AbsListViewModel<DataFeed>() {

    private val apiKey = "9fa07562ecbfe0efa46a3b7c5fcc1448"
    private val num = 10
    private val page = 1

    override fun createDataSource(): DataSource<Int, DataFeed> {

        return object : PageKeyedDataSource<Int, DataFeed>() {

            override fun loadInitial(
                params: LoadInitialParams<Int>,
                callback: LoadInitialCallback<Int, DataFeed>
            ) {
                getHomeList(page, callback)
            }

            override fun loadAfter(
                params: LoadParams<Int>,
                callback: LoadCallback<Int, DataFeed>
            ) {
                getHomeList(params.key, params.key + 1, callback)
            }

            override fun loadBefore(
                params: LoadParams<Int>,
                callback: LoadCallback<Int, DataFeed>
            ) {
                callback.onResult(Collections.emptyList(), null)
            }


        }
    }


    fun getHomeList(
        page: Int,
        callback: PageKeyedDataSource.LoadInitialCallback<Int, DataFeed>
    ) {

        viewModelScope.launch {
            val homeFeed = repository.getHomeList(apiKey, num, page)
            if (homeFeed is NetResult.Success) {
                callback.onResult(homeFeed.data, null, 1)
            } else if (homeFeed is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    homeFeed.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun getHomeList(
        page: Int,
        key: Int,
        callback: PageKeyedDataSource.LoadCallback<Int, DataFeed>
    ) {
        viewModelScope.launch {
            val homeFeed = repository.getHomeList(apiKey, num, page)
            if (homeFeed is NetResult.Success) {
                callback.onResult(homeFeed.data, key)
            } else if (homeFeed is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    homeFeed.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}