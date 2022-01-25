package com.firstaap.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myRecyclerView: RecyclerView = findViewById(R.id.myRecyclerView)

        myRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val userList = ArrayList<user>()

        userList.add(user("Anjali", "9765665054", "https://picsum.photos/id/200/200/300"))
        userList.add(user("Sourabh", "9875456698", "https://picsum.photos/id/202/300"))
        userList.add(user("Chiku", "7875461235", "https://picsum.photos/id/203/300"))
        userList.add(user("Mini", "8945612335", "https://picsum.photos/id/204/300"))
        userList.add(user("Chitra", "9451235886", "https://picsum.photos/id/205/300"))

        val adapter = CustomAdapter(userList)

        myRecyclerView.adapter = adapter
    }
}