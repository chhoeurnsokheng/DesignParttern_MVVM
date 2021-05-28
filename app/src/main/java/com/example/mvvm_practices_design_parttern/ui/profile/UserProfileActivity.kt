package com.example.mvvm_practices_design_parttern.ui.profile

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm_practices_design_parttern.R
import com.google.android.material.button.MaterialButton


class UserProfileActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        var all=findViewById<MaterialButton>(R.id.all)
        all.setOnClickListener {
            all.setBackgroundColor(R.color.browser_actions_divider_color)
        }
    }
}
