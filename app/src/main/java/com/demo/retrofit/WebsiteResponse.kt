package com.demo.retrofit

/**
 * Created by guoxiaodong on 3/26/21 15:27
 */
data class WebsiteResponse(
    val data: List<Website>,
    val errorCode: Int,
    val errorMsg: String
)

data class Website(
    val id: Int,
    val category: String,
    val icon: String,
    val link: String,
    val name: String,
    val order: Int,
    val visible: Int
)
