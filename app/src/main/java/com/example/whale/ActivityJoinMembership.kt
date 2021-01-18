package com.example.whale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast
import androidx.core.content.res.TypedArrayUtils.getText
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
//import com.google.firebase.auth.ktx.auth
//import com.google.firebase.ktx.Firebase

import kotlinx.android.synthetic.main.activity_join_membership.*


class ActivityJoinMembership : AppCompatActivity() {
    //var auth : FirebaseAuth? =null

    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_membership)
        //auth = Firebase.auth
        //auth = FirebaseAuth.getInstance()



        btn_joinmembershipdata.setOnClickListener{
            createUserId()
        }

        btn_TermAndRegulations.setOnClickListener{
            val intent = Intent(this, termandregulations::class.java)
            startActivity(intent)
        }


    }
    fun createUserId(){
        var id = join_id.text.toString()
        var pw = join_pw.text.toString()



            if (join_pw.text.toString() == join_pwconfirm.text.toString()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(id, pw).addOnCompleteListener { task ->

                        if (task.isSuccessful) {
                            Toast.makeText(this, "회원가입이 되었습니다", Toast.LENGTH_SHORT).show()
                            saveData()

                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)

                        } else {
                            Toast.makeText(this, "앱의 문제로 회원가입이 안 되었습니다", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            else {
                Toast.makeText(this, "비밀번호가 일치한지 확인해주세요", Toast.LENGTH_SHORT).show()
            }


    }

    fun saveData(){
        var setEditTextString = join_nickname.text.toString()
        var setidString =join_id.text.toString()
        var setpwString = join_pw.text.toString()
        var array = arrayListOf<String>()
        var follower_1 = arrayListOf<String>()
        var follower_2 = arrayListOf<String>()
        var follower_3 = arrayListOf<String>()
        var follower_4 = arrayListOf<String>()
        var follower_5 = arrayListOf<String>()
        var follower_6 = arrayListOf<String>()

        var map = mutableMapOf<String, Any>()

        //여기가 follower 다 array로 만든 코드
        map["nickname"] = setEditTextString
        map["id"] = setidString
        map["pw"] = setpwString
        map["leaderQuest"] = 0
        map["totalQuest"] = 0
        map["finishQuest"] = 0
        map["follower1"] = follower_1
        map["follower2"] = follower_2
        map["follower3"] = follower_3
        map["follower4"] = follower_4
        map["follower5"] = follower_5
        map["follower6"] = follower_6
        map["questList"] = array

        FirebaseFirestore.getInstance()
            .collection("users")
            .document(setidString)
            .set(map)


   }

}

