package com.cs.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cs.home.databinding.LayoutHomeListBinding
import com.cs.home.model.home.DataFeed
import com.cs.lib_base.service.webview.warp.WebViewWarpService

/**
 * Create by liwen on 2020-05-19
 */
class HomeListAdapter(context: Context) :

    PagedListAdapter<DataFeed, HomeListAdapter.ViewHolder>(object :

        DiffUtil.ItemCallback<DataFeed>() {
        override fun areContentsTheSame(
            oldItem: DataFeed,
            newItem: DataFeed
        ): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(
            oldItem: DataFeed,
            newItem: DataFeed
        ): Boolean {
            return oldItem.ctime == newItem.ctime
        }
    }) {


    private val inflater = LayoutInflater.from(context)
    private val mContext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = LayoutHomeListBinding.inflate(inflater, parent, false)

        return ViewHolder(binding.root, binding, mContext)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setData(getItem(position)!!)

    }

    class ViewHolder(
        itemView: View,
        binding: LayoutHomeListBinding,
        context: Context
    ) : RecyclerView.ViewHolder(itemView) {

        private var mBinding = binding
        private var mContext = context

        fun setData(datasBean: DataFeed) {
            mBinding.feed = datasBean

            mBinding.parentItem.setOnClickListener {
                WebViewWarpService.instance.start(mContext, datasBean.title, datasBean.url)
            }
        }

    }
}