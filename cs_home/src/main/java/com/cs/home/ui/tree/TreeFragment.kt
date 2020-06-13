package com.cs.home.ui.tree

import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cs.home.R
import com.cs.home.adapter.TreeListAdapter
import com.cs.home.databinding.FragmentTreeBinding
import com.cs.home.model.tree.TreeData
import com.cs.lib_base.base.BaseFragment


class TreeFragment : BaseFragment<TreeViewModel, FragmentTreeBinding>() {

    private lateinit var mAdapter: TreeListAdapter

    private lateinit var mRecyclerView: RecyclerView

    override fun getLayoutResId(): Int = R.layout.fragment_tree


    override fun initData() {

        mViewModel.getTreeList()

        //请求数据
        mViewModel.getTreeDataLiveData().observe(this, Observer<MutableList<TreeData>> {
            mAdapter = TreeListAdapter(requireActivity(), it)
            mRecyclerView.adapter = mAdapter
        })

    }

    override fun initView() {

        mRecyclerView = mViewBinding.recyclerView
        mRecyclerView.layoutManager = LinearLayoutManager(
            activity
            , LinearLayoutManager.VERTICAL, false

        )

        val decoration = DividerItemDecoration(activity, VERTICAL)
        decoration.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.home_list_divider)!!)

        mRecyclerView.addItemDecoration(decoration)

    }


}