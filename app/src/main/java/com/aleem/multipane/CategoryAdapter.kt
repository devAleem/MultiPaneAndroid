package com.aleem.multipane

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryViewHolder(itemView: View,listener: OnCategoryClickListener): RecyclerView.ViewHolder(itemView) {
    val tvCategory = itemView.findViewById<Button>(R.id.btnCategory)
    init{
        tvCategory.setOnClickListener{
            listener.onItemClick(adapterPosition)
        }
    }
}

interface OnCategoryClickListener{
    fun onItemClick(position:Int)
}


class CategoryAdapter:RecyclerView.Adapter<CategoryViewHolder>(){
    private lateinit var listener :OnCategoryClickListener
    val data = listOf(
        Categories("One"),
        Categories("Two"),
        Categories("Three"),
        Categories("Four"),
        Categories("Five"),
        Categories("Six"),
        Categories("Seven"),
        Categories("Eight"),
        Categories("Nine"),
        Categories("Ten"),
    )

    fun setOnCategoryClickListener(mListener: OnCategoryClickListener){
        Log.i("MLait","here")
        listener = mListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.category_layout,parent,false)
        return CategoryViewHolder(itemView,listener)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = data[position]
        holder.tvCategory.text = item.categoryName
    }

    override fun getItemCount(): Int {
        return data.size
    }
}