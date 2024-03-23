package com.example.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnCreateContextMenuListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.app.MenuBottomSheetFragment

import com.example.app.R
import com.example.app.adapter.PopularAdapter
import com.example.app.databinding.FragmentHomeBinding
import java.text.FieldPosition


class HomeFragment : Fragment() {
    private val binding :FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.viewAllMenu.setOnClickListener{
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }


       return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.burger,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.burger,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.burger,ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)
        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {

            }

//            override fun onItemSelected(position: Int) {
//                TODO("Not yet implemented")
//            }
override fun onItemSelected(position: Int) {

    val itemPosition = imageList[position]
    val itemMessage = "Selected Imafe $position"
    Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()

}

    })

    val foodName = listOf("Chole Bhature", "Sandwich", "Burger", "Fried Rice")
    val Price = listOf("₹50", "₹40", "₹60", "₹50")
    val populerFoodImages = listOf(R.drawable.cholebhature, R.drawable.sandwich, R.drawable.burger, R.drawable.friedrice)
    val adapter = PopularAdapter(foodName, Price, populerFoodImages)
    binding.PopulerRecylerView.layoutManager = LinearLayoutManager (requireContext())
        binding.PopulerRecylerView.adapter=adapter



}
    companion object{


    }    }
