package com.example.whale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whale.Util.MyAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile_info.*
import kotlinx.android.synthetic.main.activity_leader.*
import kotlinx.android.synthetic.main.task_adding_popup.*
import java.util.*
import kotlin.collections.ArrayList

class ProfileInfoActivity : AppCompatActivity(), View.OnClickListener {

    internal var dataSource: MutableList<String> = ArrayList<String>()
    var todaycount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_info)
        adding_task.setOnClickListener(this)

        btn_back.setOnClickListener {
            val intent = Intent(this, LeaderActivity::class.java)
            startActivity(intent)
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