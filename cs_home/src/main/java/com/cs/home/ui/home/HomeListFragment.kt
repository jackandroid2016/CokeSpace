package com.cs.home.ui.home

import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.cs.home.adapter.HomeListAdapter
import com.cs.home.model.home.DataFeed
import com.cs.lib_base.base.AbsListFragment
import com.cs.lib_base.datasource.MutablePageKeyedDataSource

/**
 * Create by liwen on 2020/6/4
 */
class HomeListFragment : AbsListFragment<DataFeed, HomeListViewModel>() {

    override fun onCreateViewAfter() {
        super.onCreateViewAfter()
        hiddenActionBar()
        setDividerItemDecoration(-1)
    }

    override fun generateAdapter(): PagedListAdapter<DataFeed, RecyclerView.ViewHolder> {
        return HomeListAdapter(requireContext()) as PagedListAdapter<DataFeed, RecyclerView.ViewHolder>
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        mViewModel.getDataSource()!!.invalidate()
        finishRefresh()

    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {

        //当加载更多的时候返回了空数据 需要手动接管数据加载否则paging框架将不会继续加载数据

        val currentList = mAdapter.currentList

        if (currentList == null || currentList.size <= 0) {
            return
        }

        val key = currentList.size / 20

        mViewModel.getHomeList(
            key,
            key + 1,
            object : PageKeyedDataSource.LoadCallback<Int, DataFeed>() {
                override fun onResult(data: MutableList<DataFeed>, adjacentPageKey: Int?) {

                    //把data转成pageList
                    val dataSource = MutablePageKeyedDataSource<DataFeed>()

                    dataSource.data.addAll(currentList)
                    dataSource.data.addAll(data)

                    val pageList =
                        dataSource.buildNewPageList(mAdapter.currentList!!.config)

                    mAdapter.submitList(pageList)

                }
            })

        finishRefresh()
    }

}