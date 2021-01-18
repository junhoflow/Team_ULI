package com.example.whale

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_leader.*
import kotlinx.android.synthetic.main.activity_leader.nowtime
import kotlinx.android.synthetic.main.activity_personal_profile.*
import kotlinx.android.synthetic.main.friend_adding_popup.*
import java.text.SimpleDateFormat
import java.util.*

class LeaderActivity : AppCompatActivity(){

    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leader)

        if(App.true_2 == 1)
        {
            Glide.with(this).load(App.follower_2[0]).into(imageView2)
            second_profile_name.text = App.follower_2[1]
        }
        if(App.true_3 == 1)
        {
            Glide.with(this).load(App.follower_3[0]).into(imageView3)
            third_profile_name.text = App.follower_3[1]
        }
        if(App.true_4 == 1)
        {
            Glide.with(this).load(App.follower_4[0]).into(imageView4)
            fourth_profile_name.text = App.follower_4[1]
        }
        if(App.true_5 == 1)
        {
            Glide.with(this).load(App.follower_5[0]).into(imageView5_)
            five_profile_name.text = App.follower_5[1]
        }
        if(App.true_6 == 1)
        {
            Glide.with(this).load(App.follower_6[0]).into(imageView6)
            six_profile_name.text = App.follower_6[1]
        }

        TodayTotalCount.text = App.leader_quest.toString()

        val username: TextView = findViewById<TextView>(R.id.UserName)
        val username2: TextView = findViewById<TextView>(R.id.username_1)

        if(App.name != null)
        {
            username.text = App.name
            username2.text = App.name
        }

        TodayTotalCount.text = App.leader_quest.toString()

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
            val followerInput = dialogView.findViewById<EditText>(R.id.addingfollower)

            if(App.true_2 == 0)
            {
                builder.setView(dialogView).show()
                button2.setOnClickListener {
                    val intent = Intent(this, LeaderActivity::class.java)
                    startActivity(intent)
                }
                button.setOnClickListener {
                    App.follower_2.add("https://postfiles.pstatic.net/MjAyMTAxMThfMTgg/MDAxNjEwOTY5NTM1MTU0.NAEGuGN-ixjgIeg_USFEBQ1urrqYlKKU513rS3LySTgg.eWdBucFeiiJuqFHa6OLz62FnV2Cigm2sEnA4Hbo6748g.JPEG.tikibird/profile2.jpg?type=w773")
                    App.follower_2.add(followerInput.text.toString())
                    App.true_2 = 1
                    auth = FirebaseAuth.getInstance()
                    val user = auth.currentUser?.email
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user.toString()).update("follower2", App.follower_2)
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user.toString()).update("follower2_true", App.true_2)
                    val intent = Intent(this, LeaderActivity::class.java)
                    startActivity(intent)
                }

            }
            else
            {
                val intent = Intent(this, ProfileInfoActivity::class.java)
                startActivity(intent)
            }
        }


        layout3.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.friend_adding_popup, null)
            val button = dialogView.findViewById<Button>(R.id.ok)
            val button2 = dialogView.findViewById<Button>(R.id.cancel_btn)
            val followerInput = dialogView.findViewById<EditText>(R.id.addingfollower)

            if(App.true_3 == 0)
            {
                builder.setView(dialogView).show()
                button2.setOnClickListener {
                    val intent = Intent(this, LeaderActivity::class.java)
                    startActivity(intent)
                }
                button.setOnClickListener {
                    App.follower_3.add("https://postfiles.pstatic.net/MjAyMTAxMThfMTAx/MDAxNjEwOTY5NTM3NzQw.XAfWuXZpG7Bq7e5gdBiClWDABqABneTYwQWPmvKKnQgg.rs--sxiwnxdZ65SlMJexhueTZ1Iy61BEgLMcn9ZG450g.JPEG.tikibird/profile3.jpg?type=w773")
                    App.follower_3.add(followerInput.text.toString())
                    App.true_3 = 1
                    auth = FirebaseAuth.getInstance()
                    val user = auth.currentUser?.email
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user.toString()).update("follower3", App.follower_3)
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user.toString()).update("follower3_true", App.true_3)
                    val intent = Intent(this, LeaderActivity::class.java)
                    startActivity(intent)
                }

            }
            else
            {
                val intent = Intent(this, ProfileInfoActivity::class.java)
                startActivity(intent)
            }
        }
        layout4.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.friend_adding_popup, null)
            val button = dialogView.findViewById<Button>(R.id.ok)
            val button2 = dialogView.findViewById<Button>(R.id.cancel_btn)
            val followerInput = dialogView.findViewById<EditText>(R.id.addingfollower)

            if(App.true_4 == 0)
            {
                builder.setView(dialogView).show()
                button2.setOnClickListener {
                    val intent = Intent(this, LeaderActivity::class.java)
                    startActivity(intent)
                }
                button.setOnClickListener {
                    App.follower_4.add("https://postfiles.pstatic.net/MjAyMTAxMThfMTgg/MDAxNjEwOTY5NTM1MTU0.NAEGuGN-ixjgIeg_USFEBQ1urrqYlKKU513rS3LySTgg.eWdBucFeiiJuqFHa6OLz62FnV2Cigm2sEnA4Hbo6748g.JPEG.tikibird/profile2.jpg?type=w773")
                    App.follower_4.add(followerInput.text.toString())
                    App.true_4 = 1
                    auth = FirebaseAuth.getInstance()
                    val user = auth.currentUser?.email
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user.toString()).update("follower4", App.follower_4)
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user.toString()).update("follower4_true", App.true_4)
                    val intent = Intent(this, LeaderActivity::class.java)
                    startActivity(intent)
                }

            }
            else
            {
                val intent = Intent(this, ProfileInfoActivity::class.java)
                startActivity(intent)
            }
        }

        layout5.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.friend_adding_popup, null)
            val button = dialogView.findViewById<Button>(R.id.ok)
            val button2 = dialogView.findViewById<Button>(R.id.cancel_btn)
            val followerInput = dialogView.findViewById<EditText>(R.id.addingfollower)

            if(App.true_5 == 0)
            {
                builder.setView(dialogView).show()
                button2.setOnClickListener {
                    val intent = Intent(this, LeaderActivity::class.java)
                    startActivity(intent)
                }
                button.setOnClickListener {
                    App.follower_5.add("https://postfiles.pstatic.net/MjAyMTAxMThfMTgg/MDAxNjEwOTY5NTM1MTU0.NAEGuGN-ixjgIeg_USFEBQ1urrqYlKKU513rS3LySTgg.eWdBucFeiiJuqFHa6OLz62FnV2Cigm2sEnA4Hbo6748g.JPEG.tikibird/profile2.jpg?type=w773")
                    App.follower_5.add(followerInput.text.toString())
                    App.true_5 = 1
                    auth = FirebaseAuth.getInstance()
                    val user = auth.currentUser?.email
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user.toString()).update("follower5", App.follower_5)
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user.toString()).update("follower5_true", App.true_5)
                    val intent = Intent(this, LeaderActivity::class.java)
                    startActivity(intent)
                }

            }
            else
            {
                val intent = Intent(this, ProfileInfoActivity::class.java)
                startActivity(intent)
            }
        }
        layout6.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.friend_adding_popup, null)
            val button = dialogView.findViewById<Button>(R.id.ok)
            val button2 = dialogView.findViewById<Button>(R.id.cancel_btn)
            val followerInput = dialogView.findViewById<EditText>(R.id.addingfollower)

            if(App.true_6 == 0)
            {
                builder.setView(dialogView).show()
                button2.setOnClickListener {
                    val intent = Intent(this, LeaderActivity::class.java)
                    startActivity(intent)
                }
                button.setOnClickListener {
                    App.follower_6.add("https://postfiles.pstatic.net/MjAyMTAxMThfMTgg/MDAxNjEwOTY5NTM1MTU0.NAEGuGN-ixjgIeg_USFEBQ1urrqYlKKU513rS3LySTgg.eWdBucFeiiJuqFHa6OLz62FnV2Cigm2sEnA4Hbo6748g.JPEG.tikibird/profile2.jpg?type=w773")
                    App.follower_6.add(followerInput.text.toString())
                    App.true_6 = 1
                    auth = FirebaseAuth.getInstance()
                    val user = auth.currentUser?.email
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user.toString()).update("follower6", App.follower_6)
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user.toString()).update("follower6_true", App.true_6)
                    val intent = Intent(this, LeaderActivity::class.java)
                    startActivity(intent)
                }

            }
            else
            {
                val intent = Intent(this, ProfileInfoActivity::class.java)
                startActivity(intent)
            }
        }

        val currentDateTime = Calendar.getInstance().time
        var dateFormat = SimpleDateFormat("yyyy년 MM월 dd일 EE요일", Locale.KOREA).format(currentDateTime)

        nowtime.text = dateFormat

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