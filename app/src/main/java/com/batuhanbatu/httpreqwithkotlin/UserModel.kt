package com.batuhanbatu.httpreqwithkotlin

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("authorname")
    val authorname: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("price")
    val price: String = ""
)