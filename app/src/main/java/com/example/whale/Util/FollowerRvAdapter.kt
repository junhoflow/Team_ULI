package com.example.whale.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.whale.*
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

            var b = holder.quest1?.text.toString()


            if(parseInt(holder.point1?.text.toString()) != 0) {
                for(s in  App.questList.indices)
                {
                    if(b == App.questList[s] && s != null)
                    {
                        App.questList.removeAt(s)
                        App.pointList.removeAt(s)

                        App.finish_quest_= App.finish_quest_ + 1
                        holder.ingquest?.text =App.total_quest_.toString()

                        App.total_point =  App.total_point +parseInt(holder.point1?.text.toString())
                    }
                }

            }


            FirebaseFirestore.getInstance()
                .collection("users")
                .document(c)
                .update("point", App.total_point)


            FirebaseFirestore.getInstance()
                .collection("users")
                .document(c).update("finishQuest", App.finish_quest_ )


            FirebaseFirestore.getInstance()
                .collection("users")
                .document(c).update("totalQuest", App.total_quest_)

            FirebaseFirestore.getInstance()
                .collection("users")
                .document(c).update("pointList", App.pointList)

            FirebaseFirestore.getInstance()
                .collection("users")
                .document(c).update("questList", App.questList)

            Toast.makeText(context,"퀘스트 ${b}이(가) 선택되었습니다.", Toast.LENGTH_SHORT).show()
            App.refreshing2++
            val intent3 = Intent(context, ProfileInfoActivity::class.java)
            context.startActivity(intent3)
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