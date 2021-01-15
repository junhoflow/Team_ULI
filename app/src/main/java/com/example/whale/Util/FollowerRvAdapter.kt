package com.example.whale.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whale.R
import com.example.whale.ThingsTodo

class FollowerRvAdapter(val context: Context, val questList: ArrayList<ThingsTodo>) :
    RecyclerView.Adapter<FollowerRvAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.follower_rv_item, parent,false)
        return Holder(view)
    }
    override fun getItemCount(): Int {
        return questList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(questList[position], context)
    }

    inner class Holder(itemView: View?):RecyclerView.ViewHolder(itemView!!){
        val point1 = itemView?.findViewById<TextView>(R.id.item_point)
        val quest1 = itemView?.findViewById<TextView>(R.id.item_quest)

        fun bind(toDo: ThingsTodo, context: Context)
        {
            point1?.text = toDo.point
            quest1?.text = toDo.title
        }
    }

}