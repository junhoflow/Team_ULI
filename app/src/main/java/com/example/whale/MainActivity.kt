package com.example.whale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //var auth : FirebaseAuth? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun loginUserId(email: String, password: String) {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    Toast.makeText(this, "로그인이 되었습니다", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "로그인이 안되었습니다", Toast.LENGTH_SHORT).show()
                }

            }

        }

        //auth = FirebaseAuth.getInstance()
        btn_join.setOnClickListener {
            val intent3 = Intent(this, LeaderActivity::class.java)
            startActivity(intent3)
            loginUserId(btn_idforlogin.text.toString(), btn_pwforlogin.text.toString())
        }

        btn_join2.setOnClickListener {
            val intent2 = Intent(this, FollowerActivity::class.java)
            startActivity(intent2)
            loginUserId(btn_idforlogin.text.toString(), btn_pwforlogin.text.toString())
        }

        btn_forjoin.setOnClickListener {
            val intent = Intent(this, ActivityJoinMembership::class.java)
            startActivity(intent)

        }
    }
}
