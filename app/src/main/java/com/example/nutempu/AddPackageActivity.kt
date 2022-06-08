package com.example.nutempu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.nutempu.databinding.ActivityAddPackageBinding

class AddPackageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddPackageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPackageBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.tvIconClose.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
        binding.btNewPackage.setOnClickListener {
            var TrackingNumber = binding.etTrackingNumber.text.toString()
            Toast.makeText(getApplicationContext(), TrackingNumber, Toast.LENGTH_LONG).show()
        }
    }
}