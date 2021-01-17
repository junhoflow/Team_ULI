package com.example.whale

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_leader.*
import kotlinx.android.synthetic.main.friend_adding_popup.*
import kotlinx.android.synthetic.main.friend_adding_popup.view.*
import java.text.SimpleDateFormat
import java.util.*

class LeaderActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leader)

        val username: TextView = findViewById<TextView>(R.id.UserName)
        val username2: TextView = findViewById<TextView>(R.id.username_1)

        if(App.name != null)
        {
            username.text = App.name
            username2.text = App.name
        }

        val refreshing : Int = App.count

        TodayTotalCount.text = refreshing.toString()

        val layout1 = findViewById<LinearLayout>(R.id.layout1)
        val layout2 = findViewById<LinearLayout>(R.id.layout2)
        val layout3 = findViewById<LinearLayout>(R.id.layout3)
        val layout4 = findViewById<LinearLayout>(R.id.layout4)
        val layout5 = findViewById<LinearLayout>(R.id.layout5)
        val layout6 = findViewById<LinearLayout>(R.id.layout6)

        layout1.setOnClickListener {
            val intent = Intent(this, ProfileInfoActivity::class.java)
            startActivity(intent)
        }

        layout2.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.friend_adding_popup, null)
            val button = dialogView.findViewById<Button>(R.id.ok)
            val button2 = dialogView.findViewById<Button>(R.id.cancel_btn)
            button2.setOnClickListener {
                val intent = Intent(this, LeaderActivity::class.java)
                startActivity(intent)
            }
            button.setOnClickListener {
                val intent = Intent(this, LeaderActivity::class.java)
                startActivity(intent)
            }

            builder.setView(dialogView).show()
        }
        layout3.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.friend_adding_popup, null)
            val button = dialogView.findViewById<Button>(R.id.ok)
            val button2 = dialogView.findViewById<Button>(R.id.cancel_btn)
            button2.setOnClickListener {
                val intent = Intent(this, LeaderActivity::class.java)
                startActivity(intent)
            }
            button.setOnClickListener {
                val intent = Intent(this, LeaderActivity::class.java)
                startActivity(intent)
            }
            builder.setView(dialogView).show()
        }
        layout4.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.friend_adding_popup, null)
            val button = dialogView.findViewById<Button>(R.id.ok)
            val button2 = dialogView.findViewById<Button>(R.id.cancel_btn)
            button2.setOnClickListener {
                val intent = Intent(this, LeaderActivity::class.java)
                startActivity(intent)
            }
            button.setOnClickListener {
                val intent = Intent(this, LeaderActivity::class.java)
                startActivity(intent)
            }
            builder.setView(dialogView).show()
        }
        layout5.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.friend_adding_popup, null)
            val button = dialogView.findViewById<Button>(R.id.ok)
            val button2 = dialogView.findViewById<Button>(R.id.cancel_btn)
            button2.setOnClickListener {
                val intent = Intent(this, LeaderActivity::class.java)
                startActivity(intent)
            }
            button.setOnClickListener {
                val intent = Intent(this, LeaderActivity::class.java)
                startActivity(intent)
            }
            builder.setView(dialogView).show()
        }
        layout6.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.friend_adding_popup, null)
            val button = dialogView.findViewById<Button>(R.id.ok)
            val button2 = dialogView.findViewById<Button>(R.id.cancel_btn)
            button2.setOnClickListener {
                val intent = Intent(this, LeaderActivity::class.java)
                startActivity(intent)
            }
            button.setOnClickListener {
                val intent = Intent(this, LeaderActivity::class.java)
                startActivity(intent)
            }
            builder.setView(dialogView).show()
        }

        val currentDateTime = Calendar.getInstance().time
        var dateFormat = SimpleDateFormat("yyyy년 MM월 dd일 EE요일", Locale.KOREA).format(currentDateTime)

        nowtime.text = dateFormat



        if(intent.hasExtra("questCountAdd")) {
            var num = intent.getIntExtra("questCountAdd",0)
            App.count += num
            TodayTotalCount.text = App.count.toString()
        }
        else{}

        val dialogView = layoutInflater.inflate(R.layout.friend_adding_popup, null)
        val addingbtn : Button = dialogView.findViewById<Button>(R.id.ok)
        addingbtn.setOnClickListener{
            saveDataforfriend()
        }

        queryObserveDataforadd()


        btn_person.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }


    }


    fun queryObserveDataforadd() {
        //val layout2 = findViewById<EditText>(R.id.btn_idforlogin).text.toString()
        //val weight =
//        var a : String
//        if (intent.hasExtra("new")) {
//            FirebaseFirestore.getInstance()
//                .collection("leader")
//                .whereEqualTo("leader_email", intent.getStringExtra("new"))
//                .addSnapshotListener() { querySnapshot, firebaseFireStoreException ->
//                    var map: Map<String, Any> =
//                        querySnapshot?.documents?.first()?.data as Map<String, Any>
//                    first_profile_name.text = map["follower_name"].toString()
//                    a = map["follower_name"].toString()
//
//                } }
//        else {
//            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
//        }
    }


    fun saveDataforfriend(){
        var leader =  intent.getStringExtra("new")
        var setfriend = addingfollower.text.toString()
        var map = mutableMapOf<String, Any>()
        map["leader_email"] = leader.toString()
        map["follower_name"] = setfriend
        FirebaseFirestore.getInstance()
            .collection("leader")
            .document()
            .set(map)
    }

}