package com.example.soldierstrap.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soldierstrap.R
import com.example.soldierstrap.data.Soldier
import kotlinx.android.synthetic.main.container_layout.view.*

class SoldierAdapter : RecyclerView.Adapter<SoldierAdapter.SoldierViewHolder>() {
    private var soldiers = mutableListOf<Soldier>()

    class SoldierViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SoldierViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.container_layout, parent, false)
    )


    override fun onBindViewHolder(holder: SoldierViewHolder, position: Int) {
        holder.itemView.soldier_name.text = soldiers[position].name
    }

    fun setupSoldier(soldier: List<Soldier>) {
        this.soldiers = soldier as MutableList<Soldier>
        notifyDataSetChanged()
    }

    override fun getItemCount() = soldiers.size
}