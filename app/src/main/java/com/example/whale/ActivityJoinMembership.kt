package com.example.whale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast
//import com.google.firebase.auth.ktx.auth
//import com.google.firebase.ktx.Firebase

import kotlinx.android.synthetic.main.activity_join_membership.*


class ActivityJoinMembership : AppCompatActivity() {
    //var auth : FirebaseAuth? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_membership)
        //auth = Firebase.auth
        //auth = FirebaseAuth.getInstance()



        btn_joinmembershipdata.setOnClickListener{
            createUserId()
        }


    }
    fun createUserId(){
        var id = join_id.text.toString()
        var pw = join_pw.text.toString()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(id, pw).addOnCompleteListener{task ->

            if(task.isSuccessful){
                Toast.makeText(this, "회원가입이 되었습니다",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "회원가입이 안 되었습니다",Toast.LENGTH_SHORT).show()
            }


        }

    }


}

