package com.example.whale.Util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.whale.App
import com.example.whale.R
import com.example.whale.ThingsTodo
import com.google.firebase.firestore.FirebaseFirestore

class FollowerListAdapter(val context: Context, val questList: ArrayList<ThingsTodo>) :
    RecyclerView.Adapter<FollowerListAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.follower_list_item, parent,false)
        return Holder(view)
    }
    override fun getItemCount(): Int {
        return questList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(questList[position], context)
    }

    inner class Holder(itemView: View?):RecyclerView.ViewHolder(itemView!!){
        val quest1 = itemView?.findViewById<TextView>(R.id.item_quest2)
        val point1 = itemView?.findViewById<TextView>(R.id.item_point2)

        fun bind(toDo: ThingsTodo, context: Context)
        {
            quest1?.text = toDo.title
            point1?.text = toDo.point.toString()
        }
    }

}