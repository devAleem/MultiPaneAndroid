package com.aleem.multipane

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(itemView: View,listener: OnItemClickListener):RecyclerView.ViewHolder(itemView){
    val tvItem = itemView.findViewById<TextView>(R.id.tvItemName)
    val tvPrice = itemView.findViewById<TextView>(R.id.tvItemPrice)
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
    var itemList = listOf(
        ItemName("Chicken","900"),
        ItemName("Biryani","900"),
        ItemName("Salad","900"),
        ItemName("pizza ","900"),
        ItemName("Shawarma","900"),
        ItemName("Raita","900"),
        ItemName("Russian Salad","900"),
        ItemName("Banu Pulao","900"),
        ItemName("Chicken karahi","900"),
        ItemName("Mutton Karahi","900"),
        ItemName("Beef Tika","900"),
        ItemName("Chicken Tika","900"),
        ItemName("Mutton Tika","900"),
        ItemName("Beef Pulao","900"),
    )

    fun setOnItemClickListener(mListener: OnItemClickListener){
        Log.i("MLait","here")
        listener = mListener
    }
    fun setList(list:List<ItemName>){
        itemList = list
        notifyDataSetChanged()
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
        holder.tvPrice.text = "Rs: ${item.itemPrice}"
    }

    override fun getItemCount() = itemList.size
}