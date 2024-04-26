package com.example.app.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextSubmit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.R
import com.example.app.adapter.MenuAdapter
import com.example.app.databinding.FragmentSearchBinding
import com.google.android.material.search.SearchView
import org.w3c.dom.Text


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalMenuFoodName = listOf("Burger", "Sandwich", "Chole Bhature", "Fried Rice")
    private val originalMenuItemPrice = listOf("₹50", "₹45","₹50", "₹40", "₹50")
    private val originalMenuImage = listOf(
        R.drawable.burger,
        R.drawable.sandwich,
        R.drawable.cholebhature,
        R.drawable.friedrice,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filteredMenuFoodName,filteredMenuItemPrice,filteredMenuImage, requireContext())
        binding.menuRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

//        Setup for search view
//        setupSearchView()

        showAllMenu()

        return binding.root
    }



    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()


        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

//    private fun setupSearchView() {
//        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun OnQueryTextSubmit(query: String): Boolean {
//                // Handle search submission here
//                filterMenuItems(query)
//                return true
//            }
//
//            override fun OnQueryTextChange(newText: String): Boolean {
//                // Filter items as text is typed
//                filterMenuItems(newText)
//                return true
//            }
//        })
//    }


    private fun filterMenuItems(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()


        originalMenuFoodName.forEachIndexed{index, foodName ->
            if (foodName.contains(query.toString(), ignoreCase = true)){
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(originalMenuItemPrice[index])
                filteredMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()



    }

    companion object {

    }
}


