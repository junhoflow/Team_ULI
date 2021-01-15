package com.example.whale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.whale.Adapters.FollowerRvAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_follower.*
import kotlinx.android.synthetic.main.activity_leader.*
import java.lang.Integer.parseInt
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import kotlinx.android.synthetic.main.activity_leader.nowtime as nowtime1

class FollowerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_follower)

        queryObserveData()

        var todoList = arrayListOf<ThingsTodo>(
            ThingsTodo("엄마카드로 학원비 결제하기", "200p"),
            ThingsTodo("구몬 수학 p.33까지 학습 후 채점하기", "500p"),
            ThingsTodo("구몬 수학 p.33까지 학습 후 채점하기", "500p"),
            ThingsTodo("구몬 수학 p.33까지 학습 후 채점하기", "500p")
        )

        val fAdapter =
            FollowerRvAdapter(this, todoList)
        PointListRV.adapter = fAdapter

        val lm = LinearLayoutManager(this)
        PointListRV.layoutManager = lm
        PointListRV.setHasFixedSize(false)

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

        if(intent.hasExtra("questCount"))
        {
            questCount.text = intent.getIntExtra("questCount",0).toString()
        }

    }

    private fun queryObserveData() {
        if (intent.hasExtra("new")) {
            FirebaseFirestore.getInstance()
                .collection("users")
                .whereEqualTo("id", intent.getStringExtra("new"))
                .addSnapshotListener() { querySnapshot, firebaseFireStoreException ->
                    var map: Map<String, Any> =
                        querySnapshot?.documents?.first()?.data as Map<String, Any>
                    username_2.text = map["nickname"].toString()
                } }
        else {
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
        }

    }
}