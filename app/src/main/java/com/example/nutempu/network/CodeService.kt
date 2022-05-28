package com.example.nutempu.network

import com.example.nutempu.model.Code
import retrofit2.Call
import retrofit2.http.GET

interface CodeService {
    @GET("LB524259080HK")
    fun list() : Call<List<Code>>

}