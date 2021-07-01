package com.example.mvvm_practices_design_parttern.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("avatar")
    val avatar: String = ""
)
