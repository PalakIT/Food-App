package com.example.app.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.DetailActivity
import com.example.app.databinding.MenuItemBinding

class MenuAdapter(private val menuItemName: List<String>, private val menuItemPrice: List<String>, private val MenuImage: List<Int>, private val requireContext: Context) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
private  val itemClickListerner: OnClickListener ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }



    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = menuItemName.size
    inner class MenuViewHolder (private  val binding:MenuItemBinding):RecyclerView.ViewHolder(binding.root){

        init {
            binding.root.setOnClickListener{
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    itemClickListerner?.onItemClick(position)

                }
                // setonclicklistner to open details
                val intent = Intent(requireContext, DetailActivity::class.java)
                intent.putExtra("MenuItemName", menuItemName.get(position))
                intent.putExtra("MenuIteImage", MenuImage.get(position))
                requireContext.startActivity(intent)
            }
        }
        fun bind(position: Int) {
            binding.apply {
                menuFoodName.text = menuItemName[position]
                menuPrize.text = menuItemPrice[position]
                menuImage.setImageResource(MenuImage[position])



            }
        }

    }
    interface OnClickListener {
        fun onItemClick(position: Int)

    }
}


