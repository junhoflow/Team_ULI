package com.example.whale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun loginUserId1(email: String, password: String) {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "로그인이 되었습니다", Toast.LENGTH_SHORT).show()
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .whereEqualTo("id", email)
                        .addSnapshotListener()
                        { querySnapshot, firebaseFireStoreException ->
                            var map: Map<String, Any> =
                                querySnapshot?.documents?.first()?.data as Map<String, Any>
                            App.name = map["nickname"].toString()
                            val hi = App.name
                            Toast.makeText(this, "$hi is here", Toast.LENGTH_SHORT).show()
                        }
                    val intent3 = Intent(this, ForLoading::class.java)
                    startActivity(intent3)
                } else {
                    Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                }
            }
        }

        fun loginUserId2(email: String, password: String) {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    Toast.makeText(this, "로그인이 되었습니다", Toast.LENGTH_SHORT).show()
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .whereEqualTo("id", email)
                        .addSnapshotListener()
                        { querySnapshot, firebaseFireStoreException ->
                            var map: Map<String, Any> =
                                querySnapshot?.documents?.first()?.data as Map<String, Any>
                            App.name = map["nickname"].toString()
                        }
                    val intent2 = Intent(this, ForLoading2::class.java)
                    startActivity(intent2)
                } else {
                    Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btn_forjoin.setOnClickListener {
            val intent = Intent(this, ActivityJoinMembership::class.java)
            startActivity(intent)

        }

        btn_login.setOnClickListener{
            when {
                rbtn_leader.isChecked -> {
                    loginUserId1(btn_idforlogin.text.toString(), btn_pwforlogin.text.toString())
                }
                rbtn_follower.isChecked -> {
                    loginUserId2(btn_idforlogin.text.toString(), btn_pwforlogin.text.toString())
                }
                else -> {
                    Toast.makeText(this,"빈칸을 확인해주세요",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
