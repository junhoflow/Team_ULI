package com.example.whale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_for_loading.*

class ForLoading : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_loading)

        SystemClock.sleep(500)
        val intent = Intent(this, LeaderActivity::class.java)
        startActivity(intent)
        finish()

    }
}