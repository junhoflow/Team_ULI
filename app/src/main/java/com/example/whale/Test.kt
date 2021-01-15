package com.example.whale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_leader.*
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.add_quest.*
import org.w3c.dom.Text
import java.lang.Integer.parseInt

class Test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        var num = 0

        testButton.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.add_quest, null)
            val button = dialogView.findViewById<Button>(R.id.questPlus)

            button.setOnClickListener{
                Toast.makeText(this,"Click",Toast.LENGTH_SHORT).show()
                num++
               //AlertDialog.dismiss()
            }
            builder.setView(dialogView).show()

        }

        goBackbutton.setOnClickListener {
            val intent5 = Intent(this, LeaderActivity::class.java)
            intent5.putExtra("questCountAdd",num)
            startActivity(intent5)
        }





    }
}
