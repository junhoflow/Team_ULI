package com.example.whale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_termandregulations.*

class termandregulations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_termandregulations)



        btn_confirm.setOnClickListener{
            val intent = Intent(this, ActivityJoinMembership::class.java)
            startActivity(intent)


        }
    }
}