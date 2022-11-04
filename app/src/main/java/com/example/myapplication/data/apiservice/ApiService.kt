package com.example.myapplication.data.apiservice

import androidx.lifecycle.LiveData
import com.example.myapplication.data.dto.ResultDto
import com.example.myapplication.network.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api/?results=20")
    fun getUsers(): LiveData<ApiResponse<ResultDto>>

    @GET("api/?results=1")
    fun getUserById(): LiveData<ApiResponse<ResultDto>>
}