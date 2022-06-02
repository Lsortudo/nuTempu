package com.example.nutempu.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client: OkHttpClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()
    val BASE_URL: String = "https://proxyapp.correios.com.br/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://proxyapp.correios.com.br/v1/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun codeService(): CodeService = retrofit.create(CodeService::class.java)

}