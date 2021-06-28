package com.example.mvvm_practices_design_parttern.ui.profile

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.mvvm_practices_design_parttern.BaseActivity
import com.example.mvvm_practices_design_parttern.R
import com.example.mvvm_practices_design_parttern.databinding.ActivityUserProfileBinding

class UserProfileActivity : BaseActivity<ActivityUserProfileBinding> () {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getContentLayoutId(): Int {
        return R.layout.activity_user_profile
    }
}
