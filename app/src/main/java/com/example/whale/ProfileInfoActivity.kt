package com.example.whale

import android.app.Application
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whale.Util.MyAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile_info.*
import kotlinx.android.synthetic.main.activity_leader.*
import kotlinx.android.synthetic.main.task_adding_popup.*
import java.lang.Integer.parseInt
import java.util.*
import kotlin.collections.ArrayList

lateinit var auth: FirebaseAuth

class ProfileInfoActivity : AppCompatActivity(), View.OnClickListener {

    internal var dataSource: MutableList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_info)
        adding_task.setOnClickListener(this)

        var questList = arrayListOf<String>()
        when (App.who) {
            1 -> {
                profile_email.text = App.follower_1[1]
                questList = App.questList1
            }
            2 -> {
                profile_email.text = App.follower_2[1]
                questList = App.questList2
            }
            3 -> {
                profile_email.text = App.follower_3[1]
                questList = App.questList3
            }
            4 -> {
                profile_email.text = App.follower_4[1]
                questList = App.questList4
            }
            5 -> {
                profile_email.text = App.follower_5[1]
                questList = App.questList5
            }
            6 -> {
                profile_email.text = App.follower_6[1]
                questList = App.questList6
            }
        }

        FirebaseFirestore.getInstance()
            .collection("users")
            .whereEqualTo("id", profile_email.text)
            .addSnapshotListener()
            { querySnapshot, firebaseFireStoreException ->
                var map: Map<String, Any> =
                    querySnapshot?.documents?.first()?.data as Map<String, Any>
                App.name3 = map["nickname"].toString()
                App.finish_quest_ = parseInt(map["finishQuest"].toString())
                App.total_quest_ = parseInt(map["totalQuest"].toString())
            }

        ing_quest.text = App.total_quest_.toString()
        ed_quest.text = App.finish_quest_.toString()
        username1.text = App.name3
        username2.text = App.name3
        username3.text = App.name3

        if (App.refreshing2 != 0) {
            App.refreshing2--
            val intent = Intent(this, ForLoading4::class.java)
            startActivity(intent)
        }




        adding_task.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.task_adding_popup, null)
            val editText = dialogView.findViewById<EditText>(R.id.tastName)
            val button = dialogView.findViewById<Button>(R.id.ok2)
            val button2 = dialogView.findViewById<Button>(R.id.cancel2)

            button.setOnClickListener {
                Toast.makeText(this, "퀘스트를 추가했습니다", Toast.LENGTH_SHORT).show()
                App.leader_quest++
                questList.add(editText.text.toString())
                auth = FirebaseAuth.getInstance()
                val user = auth.currentUser?.email
                //총 제시한 퀘스트 수 증가하는 코드
                FirebaseFirestore.getInstance()
                    .collection("users")
                    .document(user.toString()).update("leaderQuest", App.leader_quest)
                //이거 일단을 내가 임의로 document "example@naver.com 으로 해놨는데 나중에 해당 follower
                //이름으로 바꺼야대
                //여기부터 leader가 추가하면 해당 follower의 questList로 추가되는 코드!!!!
                FirebaseFirestore.getInstance()
                    .collection("users")
                    .document(profile_email.text.toString())
                    .update("questList", questList)
                val intent5 = Intent(this, ProfileInfoActivity::class.java)
                startActivity(intent5)
            }

            button2.setOnClickListener {
                val intent = Intent(this, ProfileInfoActivity::class.java)
                startActivity(intent)
            }

            builder.setView(dialogView).show()
        }

        btn_back.setOnClickListener {
            App.refreshing2++
            val intent5 = Intent(this, LeaderActivity::class.java)
            startActivity(intent5)
        }



        initData()

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = (LinearLayoutManager(this))

        val adapter = MyAdapter(dataSource)
        recycler_view.adapter = adapter

        btn_insert.setOnClickListener {
            val newData = ArrayList<String>()
            for (i: Int in 0..2)
                newData.add(UUID.randomUUID().toString())
            adapter.insertItem(newData)
            recycler_view.smoothScrollToPosition(adapter.itemCount - 1)
        }

        btn_update.setOnClickListener {
            val newData = ArrayList<String>()
            for (i: Int in 0..2)
                newData.add(UUID.randomUUID().toString())
            adapter.updateItem(newData)
        }


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            adding_task.id -> {
                val dlg = MyDialog2(this)
                dlg.setOnOKClickedListener { content ->
                    Toast.makeText(this, "과제를 추가했습니다", Toast.LENGTH_SHORT).show()
                }
                dlg.start("")
            }
        }
    }

    private fun initData() {
        for (i: Int in 0..1)
            dataSource.add(UUID.randomUUID().toString())
    }
}