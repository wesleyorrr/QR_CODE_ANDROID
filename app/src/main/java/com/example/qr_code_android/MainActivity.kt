package com.example.qr_code_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qr_code_android.databinding.ActivityMainBinding
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScanner.setOnClickListener {
            initScanner()
        }
    }

    private fun initScanner() {
        IntentIntegrator(this).initiateScan()
    }
}