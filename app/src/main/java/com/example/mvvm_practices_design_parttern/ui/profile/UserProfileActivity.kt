package com.example.mvvm_practices_design_parttern.ui.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.mvvm_practices_design_parttern.BaseActivity
import com.example.mvvm_practices_design_parttern.R
import com.example.mvvm_practices_design_parttern.databinding.ActivityUserProfileBinding
import com.example.mvvm_practices_design_parttern.model.User
import kotlinx.android.synthetic.main.activity_user_profile.*

class UserProfileActivity : BaseActivity<ActivityUserProfileBinding> () {
    private lateinit var adapter: MainAdapter
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()
        setupAPICall()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupAPICall() {
        AndroidNetworking.initialize(applicationContext)
        AndroidNetworking.get("https://5e510330f2c0d300147c034c.mockapi.io/users")
            .build()
            .getAsObjectList(User::class.java, object : ParsedRequestListener<List<User>> {
                override fun onResponse(users: List<User>) {
                    shimmerFrameLayout.startShimmer()
                    shimmerFrameLayout.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                    adapter.addData(users)
                    adapter.notifyDataSetChanged()
                }
                override fun onError(anError: ANError) {
                    shimmerFrameLayout.visibility = View.GONE
                    Toast.makeText(this@UserProfileActivity, "Something Went Wrong", Toast.LENGTH_LONG).show()
                }
            })
    }

    override fun getContentLayoutId(): Int {
        return R.layout.activity_user_profile
    }
}
