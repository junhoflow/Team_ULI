package com.example.whale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_for_loading.*

class ForLoading4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_loading)

        SystemClock.sleep(100)
        val intent = Intent(this, ProfileInfoActivity::class.java)
        startActivity(intent)
        finish()

    }
}