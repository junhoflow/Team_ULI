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
import com.google.firebase.firestore.FirebaseFirestore
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
            var c = ""

            when (App.who) {
                1 -> {
                    c = App.follower_1[1]

                }
                2 -> {
                    c = App.follower_2[1]

                }
                3 -> {
                    c = App.follower_3[1]

                }
                4 -> {
                    c = App.follower_4[1]

                }
                5 -> {
                    c = App.follower_5[1]

                }
                6 -> {
                    c = App.follower_6[1]

                }
            }
            var updatePoint3  = 0
            var updatePoint2  = 0
           // App.total_quest_= App.total_quest_ - 1
            App.finish_quest_= App.finish_quest_ + 1
            holder.ingquest?.text =App.total_quest_.toString()


            FirebaseFirestore.getInstance()
                .collection("users")
                .document(c).update("finishQuest", App.finish_quest_ )


            FirebaseFirestore.getInstance()
                .collection("users")
                .document(c).update("totalQuest", App.total_quest_)

            var a = holder.point1?.text.toString()
            var b = holder.quest1?.text.toString()
//            var point = 0
//            point += parseInt(a)
            //퀘스트 삭제
            //deleteTask("정현", holder.quest1?.text.toString())
            Toast.makeText(context,"퀘스트 ${b}이(가) 선택되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    inner class Holder(itemView: View?):RecyclerView.ViewHolder(itemView!!){
        val quest1 = itemView?.findViewById<TextView>(R.id.item_quest)
        val point1 = itemView?.findViewById<TextView>(R.id.item_point)
        val layoutQuest = itemView?.findViewById<LinearLayout>(R.id.LayoutQuest)
        val ingquest =  itemView?.findViewById<TextView>(R.id.ing_quest)

        fun bind(toDo: ThingsTodo, context: Context)
        {
            quest1?.text = toDo.title
            point1?.text = toDo.point.toString()
        }
    }

}