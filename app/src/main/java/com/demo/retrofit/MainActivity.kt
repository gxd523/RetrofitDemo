package com.demo.retrofit

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.demo.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : Activity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://wanandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val websiteService: WebsiteService = retrofit.create(WebsiteService::class.java)
        val call = websiteService.requestWebsiteList("json")
        call.enqueue(object : Callback<WebsiteResponse> {
            override fun onResponse(call: Call<WebsiteResponse>, response: Response<WebsiteResponse>) {
                if (response.isSuccessful) {
                    val website = response.body()?.data?.first()
                    if (website != null) {
                        binding.textView.text = "${website.name}\n${website.link}"
                    }
                }
            }

            override fun onFailure(call: Call<WebsiteResponse>, t: Throwable) {
                Log.d("gxd", "MainActivity.onFailure-->${t.message}")
            }
        })
    }
}