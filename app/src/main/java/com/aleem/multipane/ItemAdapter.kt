package com.aleem.multipane

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(itemView: View,listener: OnItemClickListener):RecyclerView.ViewHolder(itemView){
    val tvItem = itemView.findViewById<TextView>(R.id.tvItemName)
    init {
        itemView.setOnClickListener {
            listener.onItemClick(adapterPosition,it)
        }
    }
}

interface OnItemClickListener{
    fun onItemClick(position: Int,view:View)
}

class ItemAdapter:RecyclerView.Adapter<ItemViewHolder>() {
    private lateinit var listener: OnItemClickListener
    val itemList = listOf(
        ItemName("Chicken"),
        ItemName("Biryani"),
        ItemName("Salad"),
        ItemName("pizza "),
        ItemName("Shawarma"),
        ItemName("Raita"),
        ItemName("Russian Salad"),
        ItemName("Banu Pulao"),
        ItemName("Chicken karahi"),
        ItemName("Mutton Karahi"),
        ItemName("Beef Tika"),
        ItemName("Chicken Tika"),
        ItemName("Mutton Tika"),
        ItemName("Beef Pulao"),
    )

    fun setOnItemClickListener(mListener: OnItemClickListener){
        Log.i("MLait","here")
        listener = mListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
       val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_layout,parent,false)
        return ItemViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.tvItem.text = item.itemName
    }

    override fun getItemCount() = itemList.size
}