package com.batuhanbatu.httpreqwithkotlin

import kotlinx.coroutines.Deferred
import com.batuhanbatu.httpreqwithkotlin.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface IApiHttpCat {

    @GET("get_all_poetry_to_date2.php")
    fun getHttpCatList(): Call<List<UserModel>>
}