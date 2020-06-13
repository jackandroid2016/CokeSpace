package com.cokespace.zl

import com.win.lib_net.net.RetrofitClient
import org.koin.dsl.module
import com.win.ft_home.di.treeRepoModule
import com.win.ft_home.di.treeViewModelModule

/**
 * Create by liwen on 2020/5/25
 */


var retrofitModule = module {
    single {
        RetrofitClient.instance
    }
}


val allModule = listOf(
    treeRepoModule, treeViewModelModule,
//    detailRepoModule, detailViewModelModule,
//    loginRepoModule, loginViewModelModule,
//    searchRepoModule, searchViewModelModule,
    retrofitModule

)