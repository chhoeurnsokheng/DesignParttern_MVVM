package com.example.mvvm_practices_design_parttern.ui.main

import android.os.Bundle
import android.widget.SearchView
import com.example.mvvm_practices_design_parttern.BaseActivity
import com.example.mvvm_practices_design_parttern.R
import com.example.mvvm_practices_design_parttern.databinding.ActivityMainBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback


class MainActivity :BaseActivity<ActivityMainBinding>(), OnMapReadyCallback {
    private val mMap: GoogleMap? = null
    var searchView: SearchView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





    }

    override fun onMapReady(p0: GoogleMap?) {
        TODO("Not yet implemented")
    }

    override fun getContentLayoutId(): Int = R.layout.activity_main
}