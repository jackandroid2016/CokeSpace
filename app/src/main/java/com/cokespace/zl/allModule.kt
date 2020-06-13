package com.cokespace.zl

import com.cs.lib_net.net.RetrofitClient
import org.koin.dsl.module
import com.cs.home.di.treeRepoModule
import com.cs.home.di.treeViewModelModule

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