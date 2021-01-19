package com.example.whale.Adapters

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
import java.lang.Integer.parseInt

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
        holder.layoutQuest?.setOnClickListener{

            var a = holder.point1?.text.toString()
            var b = holder.quest1?.text.toString()
            App.addPoint += parseInt(a)
            //퀘스트 삭제
            //deleteTask("정현", holder.quest1?.text.toString())
            Toast.makeText(context,"퀘스트 ${b}이(가) 선택되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    inner class Holder(itemView: View?):RecyclerView.ViewHolder(itemView!!){
        val quest1 = itemView?.findViewById<TextView>(R.id.item_quest)
        val point1 = itemView?.findViewById<TextView>(R.id.item_point)
        val layoutQuest = itemView?.findViewById<LinearLayout>(R.id.LayoutQuest)
        val totalPoint = itemView?.findViewById<TextView>(R.id.totalpoint)

        fun bind(toDo: ThingsTodo, context: Context)
        {
            quest1?.text = toDo.title
            point1?.text = toDo.point.toString()
            totalPoint?.text = App.addPoint.toString()
        }
    }

}