package com.example.app.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.R
import com.example.app.adapter.BuyAgainAdapter

import com.example.app.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }













    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        setupRecyclerView()

        return binding.root
    }
    private fun setupRecyclerView() {
        val buyAgainFoodName = arrayListOf("Food 1","Food 2","Food 3")
        val buyAgainFoodPrice = arrayListOf("₹50","₹50","₹50")
        val buyAgainFoodImage = arrayListOf(R.drawable.burger,R.drawable.sandwich,R.drawable.cholebhature)
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage)
        binding.BuyAgainRecyclerView.adapter = buyAgainAdapter
        binding.BuyAgainRecyclerView.layoutManager =LinearLayoutManager(requireContext())
    }

    companion object {
    }
}