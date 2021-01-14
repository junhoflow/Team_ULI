package com.example.whale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whale.Util.MyAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile_info.*
import java.util.*
import kotlin.collections.ArrayList

class ProfileInfoActivity : AppCompatActivity() {

    internal  var dataSource : MutableList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_info)
        btn_back.setOnClickListener {
            val intent = Intent(this, LeaderActivity::class.java)
            startActivity(intent)
        }

        initData()

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = (LinearLayoutManager(this))

        val adapter = MyAdapter(dataSource)
        recycler_view.adapter = adapter

        btn_insert.setOnClickListener{
            val newData = ArrayList<String>()
            for(i : Int in 0..2)
                newData.add(UUID.randomUUID().toString())
            adapter.insertItem(newData)
            recycler_view.smoothScrollToPosition(adapter.itemCount-1)
        }

        btn_update.setOnClickListener{
            val newData = ArrayList<String>()
            for(i : Int in 0..2)
                newData.add(UUID.randomUUID().toString())
            adapter.updateItem(newData)
        }

    }

    private fun initData() {
        for(i : Int in 0..1)
            dataSource.add(UUID.randomUUID().toString())
    }
}