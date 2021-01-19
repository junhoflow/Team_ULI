package com.example.whale

import android.app.Application
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whale.Adapters.FollowerRvAdapter
import com.example.whale.Util.LeaderRvAdapter
import com.example.whale.Util.MyAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_follower.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile_info.*
import kotlinx.android.synthetic.main.activity_leader.*
import kotlinx.android.synthetic.main.activity_profile_info.btn_update
import kotlinx.android.synthetic.main.task_adding_popup.*
import java.lang.Integer.parseInt
import java.util.*
import kotlin.collections.ArrayList

lateinit var auth : FirebaseAuth

class ProfileInfoActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var auth: FirebaseAuth

    private lateinit var databaseReference: DatabaseReference
    internal var dataSource: MutableList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_info)
        adding_task.setOnClickListener(this)


        adding_task.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.task_adding_popup, null)
            val button = dialogView.findViewById<Button>(R.id.ok2)
            val button2= dialogView.findViewById<Button>(R.id.cancel2)
            val hahnTask = dialogView.findViewById<EditText>(R.id.questContent)
            val hahnPoint = dialogView.findViewById<EditText>(R.id.point)
            button.setOnClickListener{
                if(hahnTask.text.toString()==""||hahnPoint.text.toString()==""){
                    Toast.makeText(this, "빈칸을 확인해주세요", Toast.LENGTH_SHORT).show()
                } else{ registerTask("정현", hahnTask.text.toString(), hahnPoint.text.toString())
                    Toast.makeText(this,"퀘스트를 추가했습니다",Toast.LENGTH_SHORT).show()
                    App.leader_quest++
                    auth = FirebaseAuth.getInstance()
                    val user = auth.currentUser?.email
                    FirebaseFirestore.getInstance()
                        .collection("users")
                        .document(user.toString()).update("leaderQuest", App.leader_quest)

                    val intent5 = Intent(this, ProfileInfoActivity::class.java)
                    startActivity(intent5)}

            }

            button2.setOnClickListener{
                val intent = Intent(this, ProfileInfoActivity::class.java)
                startActivity(intent)
            }

            builder.setView(dialogView).show()
        }

        btn_back.setOnClickListener {
            val intent5 = Intent(this, LeaderActivity::class.java)
            startActivity(intent5)
        }



        initData()
        getTasksList()
        //recycler_view.setHasFixedSize(true)
        //recycler_view.layoutManager = (LinearLayoutManager(this))

        //val adapter = MyAdapter(dataSource)
        //recycler_view.adapter = adapter

        //btn_insert.setOnClickListener {
        //    val newData = ArrayList<String>()
          //  for (i: Int in 0..2)
            //    newData.add(UUID.randomUUID().toString())
            //adapter.insertItem(newData)
            //recycler_view.smoothScrollToPosition(adapter.itemCount - 1)
        //}

        //btn_update.setOnClickListener {
            //val newData = ArrayList<String>()
           // for (i: Int in 0..2)
           //     newData.add(UUID.randomUUID().toString())
           // adapter.updateItem(newData)
        //}


    }
    private fun registerTask(userName: String, task: String, point: String) {
        //auth.createUserWithEmailAndPassword(, password)
        //  .addOnCompleteListener(this) {

        //if (it.isSuccessful) {
        //val user: FirebaseUser? = auth.currentUser
        //val userId: String = user!!.uid
if( task == "" || point == ""){

    Toast.makeText(this,"빈칸을 확인해주세요", Toast.LENGTH_SHORT).show()
}else{ databaseReference = FirebaseDatabase.getInstance().getReference(userName).child(task)
    var hashMap: HashMap<String, String> = HashMap()
    hashMap.put("userId", userName)
    hashMap.put("task", task)
    hashMap.put("point", point)

    databaseReference.setValue(hashMap)}
       //.addOnCompleteListener(this) {
        // if (it.isSuccessful) {
        //  Toast.makeText(this,"과제가 등록되었습니다", Toast.LENGTH_SHORT).show()
        //   etName.setText("")
        //  etemail.setText("")
        // etpassword.setText("")
        // etconfirmpassword.setText("")
        //var intent = Intent(this, HomeActivity::class.java)
        //startActivity(intent)
        // }
        // }

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


    fun getTasksList() {
        //필요한 것 = 과제를 할당 받은 팔로워의 이름
        // val firebase: FirebaseUser = FirebaseAuth.getInstance().currentUser!!
        var databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("정현")

        databaseReference.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                App.questList.clear()
                // val currentUser = snapshot.getValue(User::class.java)
                //if(currentUser!!.profileImage == ""){
                //     img
                // }

                for (dataSnapShot: DataSnapshot in snapshot.children) {
                    val quest = dataSnapShot.getValue(ThingsTodo::class.java)

                    if (quest!!.userId.equals("정현")) {
                        App.questList.add(quest)
                    }
                }


                val questAdapter = LeaderRvAdapter(this@ProfileInfoActivity, App.questList)
                recycler_view.adapter = questAdapter
                val lm = LinearLayoutManager(this@ProfileInfoActivity)
                recycler_view.layoutManager = lm
                recycler_view.setHasFixedSize(false)
            }


        })
    }
}