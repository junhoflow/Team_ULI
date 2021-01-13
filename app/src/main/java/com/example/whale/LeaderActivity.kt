package com.example.whale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast

class LeaderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leader)


        val layout1 = findViewById<LinearLayout>(R.id.layout1)
        layout1.setOnClickListener{
            Toast.makeText(this, "알람 ON!", Toast.LENGTH_LONG).show()

        }

    }
}