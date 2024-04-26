package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.app.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class home : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_home)
        val navController=findNavController(R.id.fragmentContainerView)
        val bottomnav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomnav.setupWithNavController(navController)
        binding.notificationbutton.setOnClickListener{
            val bottomSheetDialog = Notificatoin_Bottom_Fragment()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }

    }
}