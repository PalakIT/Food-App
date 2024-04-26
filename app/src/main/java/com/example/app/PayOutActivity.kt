package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.databinding.ActivityPayOutBinding
import com.example.app.databinding.FragmentCongratsBottonSheetBinding

class PayOutActivity : AppCompatActivity() {
    lateinit var binding: ActivityPayOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.PlaceMyOrder.setOnClickListener{
            val bottonSheetDialog = CongratsBottonSheet()
            bottonSheetDialog.show(supportFragmentManager, "Test")
        }
    }
}