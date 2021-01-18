package com.example.whale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock

class ForLoading2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_loading2)

        SystemClock.sleep(100)
        val intent = Intent(this, FollowerActivity::class.java)
        startActivity(intent)
        finish()
    }
}