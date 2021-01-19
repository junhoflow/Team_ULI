package com.example.whale.Util

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.dongmin.www.customdialog.CheckDelete
import com.example.whale.R
import com.example.whale.ThingsTodo
import com.google.firebase.database.FirebaseDatabase

class LeaderRvAdapter(val context: Context, val questList: ArrayList<ThingsTodo>) :     RecyclerView.Adapter<LeaderRvAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderRvAdapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.follower_rv_item, parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return questList.size
    }
    inner class Holder(itemView: View?):RecyclerView.ViewHolder(itemView!!){
        val point1 = itemView?.findViewById<TextView>(R.id.item_point)
        val quest1 = itemView?.findViewById<TextView>(R.id.item_quest)
        val layoutQuest = itemView?.findViewById<LinearLayout>(R.id.layoutQuest)
        fun bind(toDo: ThingsTodo, context: Context)
        {
            point1?.text = toDo.point
            quest1?.text = toDo.task
        }
    }
    override fun onBindViewHolder(holder: LeaderRvAdapter.Holder, position: Int) {
        holder.bind(questList[position], context)
        holder.layoutQuest?.setOnClickListener{

var a = holder.point1?.text.toString()
          //val dlg = CheckDelete(context)
            //dlg.setOnOKClickedListener {content ->
             //   text.text= content

            //}

            deleteTask("정현", holder.quest1?.text.toString())
            Toast.makeText(context,"포인트 ${a}이 팔로워에게 적립되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }
    fun deleteTask(userName: String, taskName:String){
//필요한 것 = 업애려고하는 과제의 이름과 그 과제를 할당받은 팔로워의 이름
        FirebaseDatabase.getInstance().getReference().child(userName).child(taskName).removeValue()
    }

}