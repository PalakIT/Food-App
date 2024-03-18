package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private val binding : ActivitySignInBinding by lazy {
        ActivitySignInBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.alreadyhaveanaccount.setOnClickListener{
            val intent = Intent(this,LoginActivity2::class.java)
            startActivity(intent)
        }

    }
}