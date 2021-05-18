package com.example.mvvm_practices_design_parttern.view

import android.os.Bundle
import com.example.mvvm_practices_design_parttern.BaseActivity
import com.example.mvvm_practices_design_parttern.R
import com.example.mvvm_practices_design_parttern.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private lateinit var mainViewModel: MainViewModel
    private fun loadData() {}
    override fun getContentLayoutId(): Int {
        return R.layout.activity_main
    }
}
