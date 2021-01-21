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
import kotlinx.android.synthetic.main.activity_leader.imageView2
import kotlinx.android.synthetic.main.activity_leader.nowtime
import kotlinx.android.synthetic.main.activity_personal_profile.*
import kotlinx.android.synthetic.main.activity_profile_info.*
import kotlinx.android.synthetic.main.friend_adding_popup.*
import java.text.SimpleDateFormat
import java.util.*

class LeaderActivity : AppCompatActivity(){
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leader)
        TodayTotalCount.text = App.leader_quest.toString()

        if(App.true_1 == 1)
        {
            Glide.with(this).load(App.follower_1[0]).into(imageView1)

            FirebaseFirestore.getInstance()
                .collection("users")
                .whereEqualTo("id", App.follower_1[1])
                .addSnapshotListener()
                { querySnapshot, firebaseFireStoreException ->
                    var map: Map<String, Any> =
                        querySnapshot?.documents?.first()?.data as Map<String, Any>
                    App.name_1 = map["nickname"].toString()
                    App.finish_quest1 = Integer.parseInt(map["finishQuest"].toString())
                    App.total_quest1 = Integer.parseInt(map["totalQuest"].toString())
                }
            first_profile_name.text = App.name_1
            first_ing_quest.text = (App.total_quest1 - App.finish_quest1).toString()
            first_ed_quest.text = App.finish_quest1.toString()
        }

        if(App.true_2 == 1)
        {
            Glide.with(this).load(App.follower_2[0]).into(imageView2)

            FirebaseFirestore.getInstance()
                .collection("users")
                .whereEqualTo("id", App.follower_2[1])
                .addSnapshotListener()
                { querySnapshot, firebaseFireStoreException ->
                    var map: Map<String, Any> =
                        querySnapshot?.documents?.first()?.data as Map<String, Any>
                    App.name_2 = map["nickname"].toString()
                    App.finish_quest2 = Integer.parseInt(map["finishQuest"].toString())
                    App.total_quest2 = Integer.parseInt(map["totalQuest"].toString())
                }

            second_profile_name.text = App.name_2
            second_ing_quest.text = (App.total_quest2 - App.finish_quest2).toString()
            second_ed_quest.text = App.finish_quest2.toString()
        }

        if(App.true_3 == 1)
        {
            Glide.with(this).load(App.follower_3[0]).into(imageView3)

            FirebaseFirestore.getInstance()
                .collection("users")
                .whereEqualTo("id", App.follower_3[1])
                .addSnapshotListener()
                { querySnapshot, firebaseFireStoreException ->
                    var map: Map<String, Any> =
                        querySnapshot?.documents?.first()?.data as Map<String, Any>
                    App.name_3 = map["nickname"].toString()
                    App.finish_quest3 = Integer.parseInt(map["finishQuest"].toString())
                    App.total_quest3 = Integer.parseInt(map["totalQuest"].toString())
                }

            third_profile_name.text = App.name_3
            third_ing_quest.text = (App.total_quest3 - App.finish_quest3).toString()
            third_ed_quest.text = App.finish_quest3.toString()
        }

        if(App.true_4 == 1)
        {
            Glide.with(this).load(App.follower_4[0]).into(imageView4)
            FirebaseFirestore.getInstance()
                .collection("users")
                .whereEqualTo("id", App.follower_4[1])
                .addSnapshotListener()
                { querySnapshot, firebaseFireStoreException ->
                    var map: Map<String, Any> =
                        querySnapshot?.documents?.first()?.data as Map<String, Any>
                    App.name_4 = map["nickname"].toString()
                    App.finish_quest4 = Integer.parseInt(map["finishQuest"].toString())
                    App.total_quest4 = Integer.parseInt(map["totalQuest"].toString())
                }

            fourth_profile_name.text = App.name_4
            fourth_ing_quest.text = (App.total_quest4 - App.finish_quest4).toString()
            fourth_ed_quest.text = App.finish_quest4.toString()
        }

        if(App.true_5 == 1)
        {
            Glide.with(this).load(App.follower_5[0]).into(imageView5)
            FirebaseFirestore.getInstance()
                .collection("users")
                .whereEqualTo("id", App.follower_5[1])
                .addSnapshotListener()
                { querySnapshot, firebaseFireStoreException ->
                    var map: Map<String, Any> =
                        querySnapshot?.documents?.first()?.data as Map<String, Any>
                    App.name_5 = map["nickname"].toString()
                    App.finish_quest5 = Integer.parseInt(map["finishQuest"].toString())
                    App.total_quest5 = Integer.parseInt(map["totalQuest"].toString())
                }

            five_profile_name.text = App.name_5
            five_ing_quest.text = (App.total_quest5 - App.finish_quest5).toString()
            five_ed_quest.text = App.finish_quest5.toString()
        }

        if(App.true_6 == 1)
        {
            Glide.with(this).load(App.follower_6[0]).into(imageView6)
            FirebaseFirestore.getInstance()
                .collection("users")
                .whereEqualTo("id", App.follower_6[1])
                .addSnapshotListener()
                { querySnapshot, firebaseFireStoreException ->
                    var map: Map<String, Any> =
                        querySnapshot?.documents?.first()?.data as Map<String, Any>
                    App.name_6 = map["nickname"].toString()
                    App.finish_quest6 = Integer.parseInt(map["finishQuest"].toString())
                    App.total_quest6 = Integer.parseInt(map["totalQuest"].toString())
                }

            six_profile_name.text = App.name_6
            six_ing_quest.text = (App.total_quest6 - App.finish_quest6).toString()
            six_ed_quest.text = App.finish_quest6.toString()
        }

        val username: TextView = findViewById<TextView>(R.id.UserName)
        val username2: TextView = findViewById<TextView>(R.id.username_1)

        if(App.name != null)
        {
            username.text = App.name
            username2.text = App.name
        }

        if(App.refreshing != 0){
            App.refreshing--
            val intent = Intent(this, ForLoading3::class.java)
            startActivity(intent)
        }

        val layout1 = findViewById<LinearLayout>(R.id.layout1)
        val layout2 = findViewById<LinearLayout>(R.id.layout2)
        val layout3 = findViewById<LinearLayout>(R.id.layout3)
        val layout4 = findViewById<LinearLayout>(R.id.layout4)
        val layout5 = findViewById<LinearLayout>(R.id.layout5)
        val layout6 = findViewById<LinearLayout>(R.id.layout6)

        layout1.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.friend_adding_popup, null)
            val button = dialogView.findViewById<Button>(R.id.ok)
            val button2 = dialogView.findViewById<Button>(R.id.cancel_btn)
            val followerInput = dialogView.findViewById<EditText>(R.id.addingfollower)

            if(App.true_1 == 0)
            {
                builder.setView(dialogView).show()
                button2.setOnClickListener {
                    val intent = Intent(this, LeaderActivity::class.java)
                    startActivity(intent)
                }
                button.setOnClickListener {
                    App.follower_1.add("https://postfiles.pstatic.net/MjAyMTAxMjFfMjQ2/MDAxNjExMjA4MDUwMDY5.BRIqcLbnswNNNlQE2iTy86UBLz8NprvPCLbRQgk7xx8g.BdO9aJKxhmTRMkoH09KpfmKnGxblLG24j-kT6QWPX9wg.PNG.tikibird/1.png?type=w773")
                    App.follower_1.add(followerInput.text.toString())
                    App.true_1 = 1
                    auth = FirebaseAuth.getInstance()
                    val user = auth.currentUser?.email
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user.toString()).update("follower1", App.follower_1)
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user.toString()).update("follower1_true", App.true_1)
                    val intent = Intent(this, LeaderActivity::class.java)
                    startActivity(intent)
                }
                App.refreshing++
            }
            else
            {
                App.who = 0
                App.who = 1
                val intent = Intent(this, ProfileInfoActivity::class.java)
                startActivity(intent)
            }
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
                    App.follower_2.add("https://postfiles.pstatic.net/MjAyMTAxMjFfMTA4/MDAxNjExMjA4MDUwMDY5.zTUj2nuZRy5yViR-axTNUjG5nnOOJwKBSvYN0kdo5RAg.o-CRuJmkdNjFtd_W1SF0VYjvGVhhNiPCCsXl8n24PKQg.PNG.tikibird/2.png?type=w773")
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
                App.refreshing++
            }
            else
            {
                App.who = 0
                App.who = 2
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
                    App.follower_3.add("https://postfiles.pstatic.net/MjAyMTAxMjFfMjA5/MDAxNjExMjA4MDUwMDcy.SDJUgU1xAAepDRjH0fR2muIap-KQ9ef6XFC12j1iQmkg.N5xEx6M8iZLO3usUxOw_37pAzuFd5CXs2Qw2eQKhWwsg.PNG.tikibird/3.png?type=w773")
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
                App.refreshing++
            }
            else
            {
                App.who = 0
                App.who = 3
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
                    App.follower_4.add("https://postfiles.pstatic.net/MjAyMTAxMjFfMTA4/MDAxNjExMjA4MDUwMDY5.zTUj2nuZRy5yViR-axTNUjG5nnOOJwKBSvYN0kdo5RAg.o-CRuJmkdNjFtd_W1SF0VYjvGVhhNiPCCsXl8n24PKQg.PNG.tikibird/2.png?type=w773")
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
                App.refreshing++
            }
            else
            {
                App.who = 0
                App.who = 4
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
                    App.follower_5.add("https://postfiles.pstatic.net/MjAyMTAxMjFfMjA5/MDAxNjExMjA4MDUwMDcy.SDJUgU1xAAepDRjH0fR2muIap-KQ9ef6XFC12j1iQmkg.N5xEx6M8iZLO3usUxOw_37pAzuFd5CXs2Qw2eQKhWwsg.PNG.tikibird/3.png?type=w773")
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
                App.refreshing++
            }
            else
            {
                App.who = 0
                App.who = 5
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
                    App.follower_6.add("https://postfiles.pstatic.net/MjAyMTAxMjFfMjQ2/MDAxNjExMjA4MDUwMDY5.BRIqcLbnswNNNlQE2iTy86UBLz8NprvPCLbRQgk7xx8g.BdO9aJKxhmTRMkoH09KpfmKnGxblLG24j-kT6QWPX9wg.PNG.tikibird/1.png?type=w773")
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
                App.refreshing++
            }
            else
            {
                App.who = 0
                App.who = 6
                val intent = Intent(this, ProfileInfoActivity::class.java)
                startActivity(intent)
            }
        }

        val currentDateTime = Calendar.getInstance().time
        var dateFormat = SimpleDateFormat("yyyy년 MM월 dd일 EE요일", Locale.KOREA).format(currentDateTime)

        nowtime.text = dateFormat





        btn_chart.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.graph_popup, null)
            val button = dialogView.findViewById<Button>(R.id.cancel_btn2)
            builder.setView(dialogView).show()

            button.setOnClickListener{
                val intent = Intent(this, LeaderActivity::class.java)
                startActivity(intent)
            }
        }

        btn_person.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }




}