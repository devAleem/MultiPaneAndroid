package com.aleem.multipane

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvCategory = itemView.findViewById<Button>(R.id.btnCategory)
}
class CategoryAdapter:RecyclerView.Adapter<CategoryViewHolder>(){
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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.category_layout,parent,false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = data[position]
        holder.tvCategory.text = item.categoryName
    }

    override fun getItemCount(): Int {
        return data.size
    }
}