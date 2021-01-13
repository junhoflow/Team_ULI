package com.example.whale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_join_membership.*

import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity() {
    //var auth : FirebaseAuth? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //auth = FirebaseAuth.getInstance()

        btn_login.setOnClickListener{
           loginUserId(login_id.text.toString(), login_pw.text.toString())

        }

        btn_joinmembership.setOnClickListener{

            val intent = Intent(this, ActivityJoinMembership::class.java)
            startActivity(intent)

        }


    }

    fun loginUserId(email : String, password:String){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener{task ->

            if(task.isSuccessful){
                Toast.makeText(this, "로그인이 되었습니다",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "로그인이 안되었습니다",Toast.LENGTH_SHORT).show()
            }


        }



    }

}





