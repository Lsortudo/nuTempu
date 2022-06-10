package com.example.nutempu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nutempu.databinding.ActivityAddPackageBinding
import com.example.nutempu.databinding.ActivityTrackPackageBinding

class TrackPackageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrackPackageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrackPackageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvIconClose.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                finish()
            }
        }
    }
}