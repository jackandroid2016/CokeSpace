package com.cs.home.ui.home

import androidx.lifecycle.Observer
import com.cs.home.R
import com.cs.home.adapter.HomeBannerAdapter
import com.cs.home.databinding.FragmentHomeBinding
import com.cs.home.model.home.Banner
import com.cs.lib_base.base.BaseFragment
import com.cs.lib_image_loader.app.ImageLoaderManager


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override fun getLayoutResId(): Int = R.layout.fragment_home

    override fun initView() {

        val supportFragmentManager = activity?.supportFragmentManager
        val beginTransaction = supportFragmentManager?.beginTransaction()
        beginTransaction?.replace(R.id.homeListContainer, HomeListFragment::class.java, null)
        beginTransaction?.commit()

    }

    override fun initData() {

        mViewModel.apply { getBanner() }
        mViewModel.apply {
            getWeather(
                "9fa07562ecbfe0efa46a3b7c5fcc1448", "上海"
            )
        }

        mViewModel.getBannerLiveData()
            .observe(viewLifecycleOwner,
                Observer<List<Banner>> {
                    mViewBinding.banner.adapter = HomeBannerAdapter(it)
                })

        mViewModel.getWeatherLiveData()
            .observe(viewLifecycleOwner, Observer {
                mViewBinding.tvRealTem.setText(it[0].real)
                mViewBinding.tvTemScope.setText(it[0].lowest + "~" + it[0].highest)
                mViewBinding.tvWeather.setText(it[0].weather)
                mViewBinding.tvDate.setText(it[0].date)
                mViewBinding.tvWeek.setText(it[0].week)
                ImageLoaderManager.getInstance().displayImageForView(mViewBinding.ivWeather, it[0].weatherimg)
            })

    }

}