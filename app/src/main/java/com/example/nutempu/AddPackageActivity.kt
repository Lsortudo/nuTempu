package com.example.nutempu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nutempu.databinding.ActivityAddPackageBinding
import com.example.nutempu.model.Code
import com.example.nutempu.network.RetrofitInitializer
import retrofit2.Call
import retrofit2.Response

class AddPackageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddPackageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPackageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvIconClose.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                finish()
            }
        }
        binding.btNewPackage.setOnClickListener {
            val trackingNumber = binding.etTrackingNumber.text.toString()

            val sharedPref = getSharedPreferences("preference_file_key", Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putString("tracking_number", trackingNumber)
                apply()
            }
            Intent(this, MainActivity::class.java).also {
                finish()
            }
            //Toast.makeText(getApplicationContext(), TrackingNumber, Toast.LENGTH_LONG).show()
        }

    }
}