package com.udacity.shoestore.ui.fragments.shoesList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ItemShoeLayoutBinding
import com.udacity.shoestore.models.Shoe

class ShoeAdapter(
    private val shoeList: List<Shoe>,
) : RecyclerView.Adapter<ShoeAdapter.ShoeHolder>() {


    class ShoeHolder(val binding: ItemShoeLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindCurrencyHolder(
            shoeItem: Shoe,
        ):Unit= with(binding) {
            shoe=shoeItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeHolder {
        val view =
            LayoutInflater.from(parent.context)
        val binding = ItemShoeLayoutBinding.inflate(view, parent, false)

        return ShoeHolder(binding)
    }

    override fun getItemCount(): Int {
        return shoeList.count()
    }

    override fun onBindViewHolder(holder: ShoeHolder, position: Int) {
        holder.bindCurrencyHolder(shoeList[position])
    }


}