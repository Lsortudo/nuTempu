package com.example.nutempu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nutempu.model.Code
import com.example.nutempu.network.RetrofitInitializer
import retrofit2.Call
import javax.security.auth.callback.Callback

class TesteApiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste_api)

        val call = RetrofitInitializer().codeService().list()
        call.enqueue(object: Callback<List<Code>?> {
            override fun onResponse(call: Call<List<Code>?>?,
                                    response: Code<List<Code>?>?) {
                response?.body()?.let {
                    val codes: List<Code> = it
                    configureList(codes)
                }
            }

            override fun onFailure(call: Call<List<Code>?>?,
                                   t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })

        val recyclerView = code_list_recyclerview
        recyclerView.adapter = CodeListAdapter(codes(), this)
    }

    private fun configureList(notes: List<Code>) {
        val recyclerView = code_list_recyclerview
        recyclerView.adapter = CodeListAdapter(codes, this)
        val layoutManager = StaggeredGridLayoutManager(
            2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }
}