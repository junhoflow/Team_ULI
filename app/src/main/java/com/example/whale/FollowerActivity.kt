package com.example.whale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.whale.Adapters.FollowerRvAdapter
import com.example.whale.Util.FollowerListAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_follower.*
import kotlinx.android.synthetic.main.activity_leader.*
import kotlinx.android.synthetic.main.address_popup.*
import kotlinx.android.synthetic.main.free_whale_popup.*
import org.w3c.dom.Text
import java.lang.Integer.parseInt
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import kotlinx.android.synthetic.main.activity_leader.nowtime as nowtime1

class FollowerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_follower)

        progress.progress = App.whaleBye % 5

        if (App.name != null) {
            username_2.text = App.name
        } else {
            Toast.makeText(this, "STILL", Toast.LENGTH_SHORT).show()
        }


        var todoList = arrayListOf<ThingsTodo>()

        for (s in App.questListFollower.indices) {
            val thing = ThingsTodo(App.questListFollower[s], App.pointListFollower[s])
            todoList.add(thing)
        }

        whale_layout.setOnClickListener {
            if (App.point >= 10000) {
                val builder = AlertDialog.Builder(this)
                val dialogView = layoutInflater.inflate(R.layout.free_whale_popup, null)
                val button = dialogView.findViewById<Button>(R.id.ok_btn)
                val button2 = dialogView.findViewById<Button>(R.id.cancel)
                builder.setView(dialogView).show()

                button.setOnClickListener {
                    App.whaleBye++
                    auth = FirebaseAuth.getInstance()
                    val user = auth.currentUser?.email
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user.toString()).update("whaleBye", App.whaleBye)
                    App.point = 0
                    auth = FirebaseAuth.getInstance()
                    val user2 = auth.currentUser?.email
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user2.toString()).update("point", App.point)
                    if (App.whaleBye % 5 == 0 && App.whaleBye != 0) {
                        val builder = AlertDialog.Builder(this)
                        val dialogView = layoutInflater.inflate(R.layout.address_popup, null)
                        val button3 = dialogView.findViewById<Button>(R.id.address_ok)
                        val button4 = dialogView.findViewById<Button>(R.id.address_cancel)
                        builder.setView(dialogView).show()

                        button3.setOnClickListener {
                            val intent = Intent(this, FollowerActivity::class.java)
                            startActivity(intent)
                        }
                        button4.setOnClickListener {
                            val intent = Intent(this, FollowerActivity::class.java)
                            startActivity(intent)
                        }
                    } else {
                        val intent = Intent(this, FollowerActivity::class.java)
                        startActivity(intent)
                    }
                }
                button2.setOnClickListener {
                    val intent = Intent(this, FollowerActivity::class.java)
                    startActivity(intent)
                }
            }
        }


        val fAdapter =
            FollowerListAdapter(this, todoList)
        PointListRV.adapter = fAdapter

        val lm = LinearLayoutManager(this)
        PointListRV.layoutManager = lm
        PointListRV.setHasFixedSize(false)

        txt_totalPoint.text = App.point.toString()

        when {
            App.point <= 1001 -> {
                Glide.with(this).load(R.raw.whale_moving).into(gif)
            }
            App.point <= 3001 -> {
                Glide.with(this).load(R.raw.whale_moving_2).into(gif)
            }
            App.point <= 6501 -> {
                Glide.with(this).load(R.raw.whale_moving_3).into(gif)
            }
            else -> {
                Glide.with(this).load(R.raw.whale_moving_4).into(gif)
            }
        }

        val currentDateTime = Calendar.getInstance().time
        var dateFormat =
            SimpleDateFormat("yyyy년 MM월 dd일 EE요일", Locale.KOREA).format(currentDateTime)

        nowtime.text = dateFormat

        button_profile.setOnClickListener {
            val intent = Intent(this, ProfileActivityFollower::class.java)
            startActivity(intent)
        }

        button_info.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.whale_point_popup, null)
            val button2 = dialogView.findViewById<Button>(R.id.whaleinfo_cancel)
            builder.setView(dialogView).show()

            button2.setOnClickListener {
                val intent = Intent(this, FollowerActivity::class.java)
                startActivity(intent)
            }
        }

        selfquest_btn.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.selfquest_adding_popup, null)
            val button = dialogView.findViewById<Button>(R.id.selfquest_ok)
            val button2 = dialogView.findViewById<Button>(R.id.selfquest_cancel)
            builder.setView(dialogView).show()

            button.setOnClickListener{
                Toast.makeText(this, "나만의 퀘스트를 추가했습니다", Toast.LENGTH_SHORT).show()

//                DB에 [나만의 퀘스트] 키워드 추가해서 업데이트 해주기


                val intent = Intent(this, FollowerActivity::class.java)
                startActivity(intent)
            }

            button2.setOnClickListener{
                val intent = Intent(this, FollowerActivity::class.java)
                startActivity(intent)
            }
        }
    }

}