package com.cs.home.ui.navi

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.cs.home.R
import com.cs.home.adapter.NavigationTabPageAdapter
import com.cs.home.databinding.NavigationDataPageBinding
import com.cs.home.model.navigation.NavigationItemDetail
import com.cs.lib_base.adapter.BaseRecyclerViewAdapter
import com.cs.lib_base.base.BaseFragment
import com.cs.lib_base.service.webview.warp.WebViewWarpService

/**
 * Create by liwen on 2020/5/30
 */
class NavigationDataPageFragment :
    BaseFragment<NavigationDataPageViewModel, NavigationDataPageBinding>() {


    private var detailList: MutableList<NavigationItemDetail>? = null

    companion object {
        fun newInstance(articles: MutableList<NavigationItemDetail>): NavigationDataPageFragment {
            val fragment = NavigationDataPageFragment()
            val bundle = Bundle()
            bundle.putString("data", Gson().toJson(articles))
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutResId(): Int = R.layout.navigation_data_page

    override fun initData() {
        val arguments = requireArguments()
        val data = arguments.getString("data")

        detailList = Gson().fromJson<MutableList<NavigationItemDetail>>(
            data,
            object : TypeToken<MutableList<NavigationItemDetail>>() {}.type
        )
    }

    override fun initView() {


        mViewBinding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        val adapter = NavigationTabPageAdapter(requireContext())
        adapter.dataList = detailList!!
        mViewBinding.recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object :
            BaseRecyclerViewAdapter.OnItemClickListener<NavigationItemDetail> {
            override fun onItemClick(item: NavigationItemDetail, position: Int) {
                WebViewWarpService.instance.start(requireContext(), item.title, item.link)
            }

        })
    }


}