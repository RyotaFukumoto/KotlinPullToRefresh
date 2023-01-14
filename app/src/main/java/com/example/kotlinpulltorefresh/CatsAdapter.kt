package com.example.kotlinpulltorefresh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CatsAdapter(private val catsList: ArrayList<Cat>): RecyclerView.Adapter<CatsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        init {
            name = view.findViewById(R.id.name)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return ViewHolder(view)
    }


    override fun getItemCount() = catsList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cat = catsList[position]
        holder.name.text = cat.name
    }
}