package com.example.whale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register_task.*

class RegisterTask : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_task)
        button.setOnClickListener{

            registerUser(intent.getStringExtra("new").toString(),task_test.text.toString(), point_text.text.toString())
        }
    }

    private fun registerUser(userName: String, task: String, point: String) {
        //auth.createUserWithEmailAndPassword(, password)
          //  .addOnCompleteListener(this) {

                //if (it.isSuccessful) {
                    //val user: FirebaseUser? = auth.currentUser
                    //val userId: String = user!!.uid

                    databaseReference = FirebaseDatabase.getInstance().getReference(userName).child(task)
                    var hashMap: HashMap<String, String> = HashMap()
                    hashMap.put("userId", userName)
                    hashMap.put("task", task)
                    hashMap.put("point", point)

                    databaseReference.setValue(hashMap).addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            Toast.makeText(this,"과제가 등록되었습니다", Toast.LENGTH_SHORT).show()
                         //   etName.setText("")
                          //  etemail.setText("")
                           // etpassword.setText("")
                           // etconfirmpassword.setText("")
                            //var intent = Intent(this, HomeActivity::class.java)
                            //startActivity(intent)
                        }
                    }

                }
           // }
   // }
}