package com.example.qr_code_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null){
            if (result.contents == null){
            Toast.makeText(this,"Cancelado",Toast.LENGTH_LONG).show()
            }else{
            Toast.makeText(this,"O valor escaneado é:${result.contents} ",Toast.LENGTH_LONG).show()

            }
        } else{
            super.onActivityResult(requestCode, resultCode, data)
        }

    }
}