package com.example.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.PopularitemBinding

class PopularAdapter (private  val items:List<String>,private val price:List<String>, private val image:List<Int>): RecyclerView.Adapter<PopularAdapter.PouplerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PouplerViewHolder {
       return PouplerViewHolder(PopularitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun onBindViewHolder(holder: PouplerViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price,images)
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