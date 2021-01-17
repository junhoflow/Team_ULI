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
import com.example.whale.Util.MyAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile_info.*
import kotlinx.android.synthetic.main.activity_leader.*
import kotlinx.android.synthetic.main.task_adding_popup.*
import java.lang.Integer.parseInt
import java.util.*
import kotlin.collections.ArrayList

var num = 0

class ProfileInfoActivity : AppCompatActivity(), View.OnClickListener {

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

            button.setOnClickListener{
                Toast.makeText(this,"퀘스트를 추가했습니다",Toast.LENGTH_SHORT).show()
                num++
                val intent5 = Intent(this, ProfileInfoActivity::class.java)
                startActivity(intent5)
            }

            button2.setOnClickListener{
                val intent = Intent(this, ProfileInfoActivity::class.java)
                startActivity(intent)
            }

            builder.setView(dialogView).show()
        }

        btn_back.setOnClickListener {
            val intent5 = Intent(this, LeaderActivity::class.java)
            intent5.putExtra("questCountAdd",num)
            startActivity(intent5)
            num = 0
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