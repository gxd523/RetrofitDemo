package com.demo.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WebsiteService {
    @GET("friend/{dataFormat}")
    fun requestWebsiteList(@Path("dataFormat") dataFormat:String): Call<WebsiteResponse>
}