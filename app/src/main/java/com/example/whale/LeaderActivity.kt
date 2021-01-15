package com.example.whale

import android.content.Intent
import android.os.Bundle
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
import kotlinx.android.synthetic.main.add_quest.*
import java.lang.Integer.parseInt


class LeaderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leader)

        val layout1 = findViewById<LinearLayout>(R.id.layout1)

        queryObserveData()

        layout1.setOnClickListener{
            val intent4 = Intent(this, Test::class.java)
            startActivity(intent4)
        }

        if(intent.hasExtra("questCountAdd")) {
            var num = intent.getIntExtra("questCountAdd",0)
            App.count += num
            questCount.text = App.count.toString()
        }
        else{

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
                    UserName.text = map["nickname"].toString()
                    username_1.text = map["nickname"].toString()
                } }
        else {
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
        }

    }
}


