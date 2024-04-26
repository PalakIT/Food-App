package com.example.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.adapter.notificationadapter
import com.example.app.databinding.FragmentNotificatoinBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class Notificatoin_Bottom_Fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificatoinBottomBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificatoinBottomBinding.inflate(layoutInflater, container, false)
        val notification = listOf("Your order has been Canceled Sucessfully","Congtrats your order has been placed")
        val notificationImages = listOf(R.drawable.sad,R.drawable.congratulation)
        val adapter = notificationadapter(
            ArrayList(notification),
            ArrayList(notificationImages)

        )
        binding.notificationrecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationrecyclerview.adapter = adapter
        return binding.root
    }

    companion object {

    }
}