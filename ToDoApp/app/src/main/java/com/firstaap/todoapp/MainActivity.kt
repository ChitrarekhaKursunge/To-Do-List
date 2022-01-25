package com.firstaap.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.DatabaseError

import com.google.firebase.database.DataSnapshot

import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fabAddTask: FloatingActionButton = findViewById(R.id.fabAddTask)
        fabAddTask.setOnClickListener {
            val intent = Intent(this, AddTask::class.java)
            startActivity(intent)
        }

        val taskRecyclerView: RecyclerView = findViewById(R.id.taskRecyclerView)
        taskRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val taskList = ArrayList<Task>()

        val database = Firebase.database
        val taskReference = database.getReference("tasks")


        taskReference.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                taskList.clear()

                for(task in snapshot.children){
                    val currentTask = Task(
                        task.child("taskName").getValue().toString(),
                        task.child("taskDescription").getValue().toString(),
                        task.child("taskPriority").getValue().toString()
                    )

                    taskList.add(currentTask)

                }
                val adapter = CustomAdapter(taskList)
                taskRecyclerView.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {

                Toast.makeText(this@MainActivity, "Failed to read value." +error.toException().toString(), Toast.LENGTH_LONG).show()
            }

        })
    }
}