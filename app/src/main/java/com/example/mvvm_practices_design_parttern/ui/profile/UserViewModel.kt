package com.example.mvvm_practices_design_parttern.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_practices_design_parttern.model.Blog

class UserViewModel : ViewModel() {
    var list = MutableLiveData<ArrayList<Blog>>()
    var newlist = arrayListOf<Blog>()
    fun add(blog: Blog) {
        newlist.add(blog)
        list.value = newlist
    }
    fun remove(blog: Blog) {
        newlist.remove(blog)
        list.value = newlist
    }
}
