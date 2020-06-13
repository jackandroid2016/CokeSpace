package com.cs.home.`interface`

import com.cs.home.model.navigation.NavigationItem

/**
 * Create by liwen on 2020/5/29
 */
interface NavigationTabItemSelectedListener {
    fun onItemSelected(item: NavigationItem, position: Int)
}