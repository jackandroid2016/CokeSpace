package com.cs.home.di

import com.cs.home.ui.home.HomeListViewModel
import com.cs.home.ui.main.MainViewModel
import com.cs.home.ui.home.HomeRepository
import com.cs.home.ui.home.HomeViewModel
import com.cs.home.ui.mine.MineViewModel
import com.cs.home.ui.navi.NavigationDataPageViewModel
import com.cs.home.ui.navi.NavigationRepository
import com.cs.home.ui.navi.NavigationViewModel
import com.cs.home.ui.project.ProjectRepository
import com.cs.home.ui.project.ProjectViewModel
import com.cs.home.ui.project.TabItemViewModel
import com.cs.home.ui.tree.TreeRepository
import com.cs.home.ui.tree.TreeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Create by liwen on 2020/5/25
 */

val treeRepoModule = module {
    single { TreeRepository(get()) }
    single { HomeRepository(get()) }
    single { ProjectRepository(get()) }
    single { NavigationRepository(get()) }
}


val treeViewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { TreeViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { ProjectViewModel(get()) }
    viewModel { TabItemViewModel(get()) }
    viewModel { MineViewModel() }
    viewModel { NavigationViewModel(get()) }
    viewModel { NavigationDataPageViewModel() }
    viewModel { HomeListViewModel(get()) }
}

