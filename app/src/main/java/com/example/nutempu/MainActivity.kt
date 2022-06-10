package com.example.nutempu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nutempu.databinding.ActivityMainBinding
import com.example.nutempu.model.Code
import com.example.nutempu.network.RetrofitInitializer
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btNewPackage.setOnClickListener {
            Intent(this, AddPackageActivity::class.java).also {
                startActivity(it)
            }
        }
        binding.btNewPackage2.setOnClickListener {
            Intent(this, TrackPackageActivity::class.java).also {
                startActivity(it)
            }
        }

        /*binding.codeItemRecyclerview.setOnClickListener {
            Intent(this, TrackPackageActivity::class.java).also {
                startActivity(it)
            }
        }*/

        recyclerView = findViewById<RecyclerView>(R.id.code_item_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CodeListAdapter(this)

        val sharedPref = getSharedPreferences("preference_file_key", Context.MODE_PRIVATE)
        val trackingNumber = sharedPref.getString("tracking_number", "")

//        val call = RetrofitInitializer().codeService().list(trackingNumber)


        val call1 = RetrofitInitializer().codeService().list("LB524259080HK")
        val call2 = RetrofitInitializer().codeService().list("LB524259080HK")
        val call3 = RetrofitInitializer().codeService().list("LB524259080HK")
        val call4 = RetrofitInitializer().codeService().list("LE272070134SE")

        getResultApi(call1)
        getResultApi(call2)
        getResultApi(call3)
        getResultApi(call4)


    }

    fun getResultApi(teste: Call<Code>) {
        teste.enqueue(object : retrofit2.Callback<Code> {
            override fun onResponse(teste: Call<Code>, response: Response<Code>) {
                response?.body()?.let {
                    val codes: Code = it
                    configureList(codes)
                }
                Log.d("TAG", response.body().toString())
            }

            override fun onFailure(teste: Call<Code>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Requisiçao falhou", Toast.LENGTH_SHORT).show()
                Log.d("TAG", t.message.toString())
            }

        })
    }

    private fun configureList(notes: Code) {
        (recyclerView.adapter as CodeListAdapter).addItem(notes)
    }


}