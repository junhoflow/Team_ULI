package com.example.whale

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_leader.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.friend_adding_popup.*
import java.text.SimpleDateFormat
import java.util.*

class LeaderActivity : AppCompatActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leader)

        val layout1 = findViewById<LinearLayout>(R.id.layout1)
        val layout2 = findViewById<LinearLayout>(R.id.layout2)
        val layout3 = findViewById<LinearLayout>(R.id.layout3)
        val layout4 = findViewById<LinearLayout>(R.id.layout4)
        val layout5 = findViewById<LinearLayout>(R.id.layout5)
        val layout6 = findViewById<LinearLayout>(R.id.layout6)

        layout1.setOnClickListener {
            val intent = Intent(this, ProfileInfoActivity::class.java)
            startActivity(intent)
        }

        layout2.setOnClickListener(this)
        layout3.setOnClickListener(this)
        layout4.setOnClickListener(this)
        layout5.setOnClickListener(this)
        layout6.setOnClickListener(this)

        val currentDateTime = Calendar.getInstance().time
        var dateFormat = SimpleDateFormat("yyyy년 MM월 dd일 EE요일", Locale.KOREA).format(currentDateTime)

        nowtime.text = dateFormat



        if(intent.hasExtra("questCountAdd")) {
            var num = intent.getIntExtra("questCountAdd",0)
            App.count += num
            TodayTotalCount.text = App.count.toString()
        }
        else{}

        val dialogView = layoutInflater.inflate(R.layout.friend_adding_popup, null)
        val addingbtn : Button = dialogView.findViewById<Button>(R.id.ok)
        addingbtn.setOnClickListener{
            saveDataforfriend()
        }

        queryObserveData()
        queryObserveDataforadd()


        btn_person.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("new", intent.getStringExtra("new"))
            startActivity(intent)
        }
    }

    fun queryObserveDataforadd() {
        //val layout2 = findViewById<EditText>(R.id.btn_idforlogin).text.toString()
        //val weight =
        var a : String
//        if (intent.hasExtra("new")) {
//            FirebaseFirestore.getInstance()
//                .collection("leader")
//                .whereEqualTo("leader_email", intent.getStringExtra("new"))
//                .addSnapshotListener() { querySnapshot, firebaseFireStoreException ->
//                    var map: Map<String, Any> =
//                        querySnapshot?.documents?.first()?.data as Map<String, Any>
//                    first_profile_name.text = map["follower_name"].toString()
//                    a = map["follower_name"].toString()
//
//                } }
//        else {
//            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
//        }
    }

    fun queryObserveData() {
        //val layout2 = findViewById<EditText>(R.id.btn_idforlogin).text.toString()
        //val weight =

        if (intent.hasExtra("new")) {
            FirebaseFirestore.getInstance()
                .collection("users")
                .whereEqualTo("id", intent.getStringExtra("new"))
                .addSnapshotListener() { querySnapshot, firebaseFireStoreException ->
                    var map: Map<String, Any> =
                        querySnapshot?.documents?.first()?.data as Map<String, Any>
                    UserName.text = map["nickname"].toString()
                    username_1.text = map["nickname"].toString()
                }
        }  else {
            //Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
        }

    }

    fun saveDataforfriend(){
        var leader =  intent.getStringExtra("new")
        var setfriend = addingfollower.text.toString()
        var map = mutableMapOf<String, Any>()
        map["leader_email"] = leader.toString()
        map["follower_name"] = setfriend
        FirebaseFirestore.getInstance()
            .collection("leader")
            .document()
            .set(map)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            layout2.id -> {
                val dlg = MyDialog(this)
                dlg.setOnOKClickedListener { content ->
                    text.text = content
                }
                dlg.start("이메일 입력")
            }
            layout3.id -> {
                val dlg = MyDialog(this)
                dlg.setOnOKClickedListener { content ->
                    text.text = content
                }
                dlg.start("이메일 입력")
            }
            layout4.id -> {
                val dlg = MyDialog(this)
                dlg.setOnOKClickedListener { content ->
                    text.text = content
                }
                dlg.start("이메일 입력")
            }layout5.id -> {
                val dlg = MyDialog(this)
                dlg.setOnOKClickedListener { content ->
                    text.text = content
                }
                dlg.start("이메일 입력")
            }layout6.id -> {
                val dlg = MyDialog(this)
                dlg.setOnOKClickedListener { content ->
                    text.text = content
                }
                dlg.start("이메일 입력")
            }
        }
    }


}