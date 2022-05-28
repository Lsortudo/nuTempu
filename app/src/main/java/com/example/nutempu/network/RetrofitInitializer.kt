package com.example.nutempu.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://proxyapp.correios.com.br/v1/sro-rastro/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun codeService(): CodeService = retrofit.create(CodeService::class.java)

}