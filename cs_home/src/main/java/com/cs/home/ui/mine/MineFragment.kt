package com.cs.home.ui.mine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cs.home.R
import com.cs.home.databinding.FragmentMineBinding
import com.cs.lib_base.base.BaseFragment
import com.cs.lib_base.utils.VersionUtil
import com.cs.lib_common_ui.flowlayout.adapter.TagAdapter

class MineFragment : BaseFragment<MineViewModel, FragmentMineBinding>() {

    override fun getLayoutResId(): Int = R.layout.fragment_mine

    override fun initData() {
//        mViewBinding.user = LoginServiceImplWrap.getUserInfo()
    }

    override fun initView() {

//        mViewBinding.name.setOnClickListener {
//            if (!LoginServiceImplWrap.isLogin()) {
//                LoginServiceImplWrap.start(requireContext())
//            }
//        }

//        LoginServiceImplWrap.getLiveData().observe(this, Observer { user ->
//            mViewBinding.user = user
//        })

//        mViewBinding.exit.setOnClickListener {
//            AlertDialog.Builder((requireContext())).setTitle("提示")
//                .setMessage("确定退出吗？")
//                .setPositiveButton(
//                    "确定"
//                ) { dialog, _ ->
//                    dialog.dismiss()
//                    LoginServiceImplWrap.removeUserInfo()
//                    initData()
//                }.setNegativeButton(
//                    "取消"
//                ) { dialog, _ ->
//                    dialog.dismiss()
//                }.show()
//        }

        mViewBinding.tvVersion.setText("V" + VersionUtil.getVersionName())

        mViewBinding.mFlowLayout.setAdapter(object : TagAdapter() {
            override fun getItemCount(): Int {
                return 2
            }

            override fun createView(
                inflater: LayoutInflater,
                parent: ViewGroup,
                position: Int
            ): View {
                return inflater.inflate(R.layout.flow_layout_item, parent, false)
            }

            override fun bindView(view: View, position: Int) {
                (view as TextView).text = "27岁"
            }

            override fun onItemViewClick(view: View, position: Int) {

            }

        })
    }


}