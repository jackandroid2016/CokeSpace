package com.cs.home.ui.tree

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cs.home.model.tree.TreeData
import com.cs.lib_base.utils.BaseContext
//import com.win.lib_base.App
import com.cs.lib_net.model.NetResult
import kotlinx.coroutines.launch

class TreeViewModel(private val treeRepository: TreeRepository) : ViewModel() {


    private val treeDataLiveData = MutableLiveData<MutableList<TreeData>>()

    fun getTreeDataLiveData(): MutableLiveData<MutableList<TreeData>> {
        return treeDataLiveData
    }

    fun getTreeList() {

        viewModelScope.launch {
            val treeData = treeRepository.getTreeList()

            if (treeData is NetResult.Success) {
                treeDataLiveData.postValue(treeData.data)
            } else if (treeData is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    treeData.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }


}