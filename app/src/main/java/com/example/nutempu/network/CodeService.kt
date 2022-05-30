package com.example.nutempu.network

import com.example.nutempu.model.Code
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CodeService {

    @GET("sro-rastro/{code}")
    fun list(@Path("code") code : String = "LB524259080HK"
    ) : Call<Code>

}