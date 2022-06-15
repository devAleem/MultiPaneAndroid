package com.aleem.multipane

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aleem.multipane.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var categoryAdapter:CategoryAdapter
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var itemListAdapter: ItemListAdapter
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

         categoryAdapter=CategoryAdapter()
         itemAdapter = ItemAdapter()
         itemListAdapter = ItemListAdapter()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvCategory.layoutManager = LinearLayoutManager(context)
        binding.rvCategory.adapter = categoryAdapter

        binding.rvItemAddedList.layoutManager = LinearLayoutManager(context)
        binding.rvItemAddedList.adapter = itemListAdapter

        categoryAdapter.setOnCategoryClickListener(object :OnCategoryClickListener{
            override fun onItemClick(position: Int) {
               val list = DataHolder.data[position + 1]
                itemAdapter.setList(list!!)
            }
        })
        binding.rvGrid.layoutManager = GridLayoutManager(context,4,)
        binding.rvGrid.adapter = itemAdapter

        itemAdapter.setOnItemClickListener(object :OnItemClickListener{
            override fun onItemClick(position: Int,view: View) {
                val tvItem = view.findViewById(R.id.tvItemName) as TextView
                val tvPrice = view.findViewById<TextView>(R.id.tvItemPrice)
                tvItem.setTextColor(Color.parseColor("#ffffff"))
                tvPrice.setTextColor(Color.parseColor("#ffffff"))
                view.setBackgroundColor(Color.parseColor("#F9C944"))
                itemListAdapter.setItemAddedList(ItemAddedList("chicken",(position + 1).toString(),"350"))
            }

        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}