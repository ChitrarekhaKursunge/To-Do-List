package com.firstaap.sharedprefernces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("myStorage", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val tvGreeting: TextView = findViewById(R.id.tvGreeting)

        val userName = sharedPref.getString("userName", "Guest")

        tvGreeting.text ="Hello "+ userName


        val etUserName: TextView = findViewById(R.id.etUserName)

        val btnSubmit: TextView = findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            editor.apply {
                putString("userName", etUserName.text.toString())
                apply()
            }
        }
    }
}