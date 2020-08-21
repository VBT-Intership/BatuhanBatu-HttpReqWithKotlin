package com.batuhanbatu.httpreqwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.batuhanbatu.httpreqwithkotlin.UserModel
import com.batuhanbatu.httpreqwithkotlin.ApiClient
import com.batuhanbatu.httpreqwithkotlin.DataAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var dataList = ArrayList<UserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyler_view.adapter = DataAdapter(dataList)
        recyler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        getUserList()
    }

    private fun getUserList() {

        val call: Call<List<UserModel>> = ApiClient.getClient.getHttpCatList()
        call.enqueue(object : Callback<List<UserModel>> {
            override fun onFailure(call: Call<List<UserModel>>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Error occured!", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<UserModel>>?,
                response: Response<List<UserModel>>?
            ) {
                if (response != null) {
                    dataList.addAll(response.body())
                    recyler_view.adapter?.notifyDataSetChanged()
                    Toast.makeText(this@MainActivity, "Success!", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
}