package com.cybervilla.recyclerviewupdate

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterMain(var listOfStrings:ArrayList<String>,
                  var onItemClickListener: OnItemClickListener)
    :RecyclerView.Adapter<AdapterMain.MyViewHolder>(){
    interface OnItemClickListener{
        fun onItemClick(position:Int)
    }
   fun update(list : ArrayList<String>){
        listOfStrings = ArrayList()
       listOfStrings.addAll(list)
       notifyDataSetChanged()
    }
    class MyViewHolder(itemView: View, onItemClickListener: OnItemClickListener)
        :RecyclerView.ViewHolder(itemView){
            val txtMain = itemView.findViewById<TextView>(R.id.txt_main)
        init {
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(adapterPosition)
            }
        }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_update,parent
        ,false)
        return MyViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val ourText = listOfStrings[position]
        holder.txtMain.text = ourText
    }

    override fun getItemCount(): Int {
        return listOfStrings.size
    }
}