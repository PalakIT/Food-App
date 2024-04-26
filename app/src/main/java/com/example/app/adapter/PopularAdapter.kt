package com.example.app.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.DetailActivity
import com.example.app.databinding.PopularitemBinding

class PopularAdapter (private  val items:List<String>,private val price:List<String>, private val image:List<Int>,private val requireContext :Context): RecyclerView.Adapter<PopularAdapter.PouplerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PouplerViewHolder {
       return PouplerViewHolder(PopularitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun onBindViewHolder(holder: PouplerViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price,images)

        holder.itemView.setOnClickListener{
            val intent = Intent(requireContext, DetailActivity::class.java)
            intent.putExtra("MenuItemName", item)
            intent.putExtra("MenuIteImage", images)
            requireContext.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class PouplerViewHolder (private val binding:PopularitemBinding): RecyclerView.ViewHolder(binding.root){
        private val imagesView = binding.imageView5
        fun bind(item: String,price:String, images: Int) {
            binding.FoodNamePopular.text=item
            binding.PrizePopular.text = price
            imagesView.setImageResource(images)


        }

    }

}