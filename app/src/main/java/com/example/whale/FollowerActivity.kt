package com.example.whale

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.whale.Adapters.FollowerRvAdapter
import com.example.whale.App.Companion.questList
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_follower.*
import java.lang.Integer.parseInt
import java.text.SimpleDateFormat
import java.util.*


class FollowerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_follower)

        if(App.name != null)
        {
            username_2.text = App.name
        }
        else{
            Toast.makeText(this,"STILL",Toast.LENGTH_SHORT).show()
        }
        getTasksList()
        //queryObserveDataforList()
        //var todoList = arrayListOf<ThingsTodo>(
         //   ThingsTodo("엄마카드로 학원비 결제하기", "200p"),
        //    ThingsTodo("구몬 수학 p.33까지 학습 후 채점하기", "500p"),
        //    ThingsTodo("구몬 수학 p.33까지 학습 후 채점하기", "500p"),
        //    ThingsTodo("구몬 수학 p.33까지 학습 후 채점하기", "500p")
        //)

        //val fAdapter =
            //FollowerRvAdapter(this, todoList)
        //PointListRV.adapter = fAdapter



        val pointCompare = parseInt(txt_totalPoint.text.toString())

        when {
            pointCompare <= 1000 -> {
                Glide.with(this).load(R.raw.whale_moving).into(gif)
            }
            pointCompare <= 3000 -> {
                Glide.with(this).load(R.raw.whale_moving_2).into(gif)
            }
            pointCompare <= 6500 -> {
                Glide.with(this).load(R.raw.whale_moving_3).into(gif)
            }
            else -> {
                Glide.with(this).load(R.raw.whale_moving_4).into(gif)
            }
        }

        val currentDateTime = Calendar.getInstance().time
        var dateFormat = SimpleDateFormat("yyyy년 MM월 dd일 EE요일", Locale.KOREA).format(currentDateTime)

        nowtime.text = dateFormat

        button_profile.setOnClickListener{
            val intent = Intent(this, ProfileActivityFollower::class.java)
            startActivity(intent)
        }
        //btn_update.setOnClickListener{

        //}

    }


    fun queryObserveDataforList() {
                  FirebaseFirestore.getInstance()
                .collection("users")
                .whereEqualTo("nickname", App.name)
                .addSnapshotListener() { querySnapshot, firebaseFireStoreException ->
                  var map: Map<String, Any> = querySnapshot?.documents?.first()?.data as Map<String, Any>
                    questList = map["todolist"] as ArrayList<ThingsTodo>
                    val fAdapter = FollowerRvAdapter(this, questList)
                    PointListRV.adapter = fAdapter
                    val lm = LinearLayoutManager(this)
                    PointListRV.layoutManager = lm
                    PointListRV.setHasFixedSize(false)


                }

    }


    fun getTasksList() {
        //val firebase: FirebaseUser = FirebaseAuth.getInstance().currentUser!!
        var databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("정현")

        databaseReference.addValueEventListener(object : ValueEventListener {


            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                questList.clear()
                // val currentUser = snapshot.getValue(User::class.java)
                //if(currentUser!!.profileImage == ""){
                //     img
                // }


                for (dataSnapShot: DataSnapshot in snapshot.children) {
                    val quest = dataSnapShot.getValue(ThingsTodo::class.java)

                    if (quest!!.userId.equals("정현")) {
                        questList.add(quest)
                    }
                }

                val questAdapter = FollowerRvAdapter(this@FollowerActivity, questList)
                PointListRV.adapter = questAdapter
                val lm = LinearLayoutManager(this@FollowerActivity)
                PointListRV.layoutManager = lm
                PointListRV.setHasFixedSize(false)
            }


        })
    }
}