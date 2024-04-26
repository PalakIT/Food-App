package com.example.app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.databinding.FragmentCongratsBottonSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CongratsBottonSheet : BottomSheetDialogFragment() {
    private lateinit var binding :FragmentCongratsBottonSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCongratsBottonSheetBinding.inflate(layoutInflater, container, false)
        binding.goHome.setOnClickListener{
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    companion object {


    }
}