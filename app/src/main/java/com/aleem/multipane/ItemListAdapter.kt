package com.aleem.multipane

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val tvItemSrNumber = itemView.findViewById<TextView>(R.id.tvSrNumber)
    val tvItemName = itemView.findViewById<TextView>(R.id.tvItem)
    val tvItemQuantity = itemView.findViewById<TextView>(R.id.tvItemQuantity)
    val tvItemEach = itemView.findViewById<TextView>(R.id.tvItemEach)
    val tvItemTotal = itemView.findViewById<TextView>(R.id.tvItemTotal)
}

class ItemListAdapter: RecyclerView.Adapter<ItemListViewHolder>() {

    private var itemList:MutableList<ItemAddedList> = mutableListOf()

    fun setItemAddedList(item:ItemAddedList){
        itemList.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.added_items_list,parent,false)
        return ItemListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        val item = itemList[position]
        holder.tvItemSrNumber.text = position.toString()
        holder.tvItemName.text = item.itemName
        holder.tvItemQuantity.text = item.itemQuantity.toString()
        holder.tvItemEach.text = item.itemPrice.toString()
        holder.tvItemTotal.text = item.itemTotalPrice.toString()
    }

    override fun getItemCount() = itemList.size
}