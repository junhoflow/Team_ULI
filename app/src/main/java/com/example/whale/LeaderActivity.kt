package com.example.whale

import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_leader.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.friend_adding_popup.*

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
            Toast.makeText(this, "알람 ON!", Toast.LENGTH_LONG).show()
        }

        layout2.setOnClickListener(this)
        layout3.setOnClickListener(this)
        layout4.setOnClickListener(this)
        layout5.setOnClickListener(this)
        layout6.setOnClickListener(this)


        queryObserveData()
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
                }
        } else {
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
        }

        if (intent.hasExtra("new")) {
            FirebaseFirestore.getInstance()
                .collection("users")
                .whereEqualTo("id", intent.getStringExtra("new"))
                .addSnapshotListener() { querySnapshot, firebaseFireStoreException ->
                    var map: Map<String, Any> =
                        querySnapshot?.documents?.first()?.data as Map<String, Any>
                    username_1.text = map["nickname"].toString()
                }
        } else {
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
        }


    }
}