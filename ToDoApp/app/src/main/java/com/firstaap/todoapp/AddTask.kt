package com.firstaap.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class AddTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val database = Firebase.database
        val taskReference = database.getReference("tasks")

        val etTask: EditText = findViewById(R.id.etTask)
        val etDescription: EditText = findViewById(R.id.etDescription)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)


        val rbLow: RadioButton = findViewById(R.id.rbLow)
        val rbMedium: RadioButton = findViewById(R.id.rbMedium)
        val rbHigh: RadioButton = findViewById(R.id.rbHigh)

        val tvAddTaskTitle: TextView = findViewById(R.id.tvAddTaskTitle)
        val btnAddTask: Button = findViewById(R.id.btnAddTask)
        val btnDeleteTask: Button = findViewById(R.id.btnDeleteTask)

        val taskType = intent.getStringExtra("taskType")
        if (taskType.equals("update"))
        {
            tvAddTaskTitle.text = "Update Task"
            btnAddTask.text = "Update Task"
            btnDeleteTask.visibility = View.VISIBLE

            etTask.setText(intent.getStringExtra("taskName"))
            etDescription.setText(intent.getStringExtra("taskDescription"))

            if(intent.getStringExtra("taskPriority").equals("Low"))
            {
                rbLow.isChecked = true
            }
            else if(intent.getStringExtra("taskPriority").equals("Medium"))
            {
                rbMedium.isChecked = true
            }
            else{
                rbHigh.isChecked = true
            }
        }

        btnDeleteTask.setOnClickListener {
            taskReference.child(intent.getStringExtra("taskName").toString()).removeValue()
            Toast.makeText(this, "Task Deleted Successfully", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        btnAddTask.setOnClickListener {
            val task = etTask.text.toString()
            val description = etDescription.text.toString()
            var priority = "low"
            if(radioGroup.checkedRadioButtonId == R.id.rbMedium)
            {
                priority = "Medium"
            }
            else if(radioGroup.checkedRadioButtonId == R.id.rbHigh)
            {
                priority = "High"
            }

            val taskObject = Task(task, description, priority)

            if(taskType.equals("update"))
            {
                taskReference.child(intent.getStringExtra("taskName").toString()).removeValue()
                taskReference.child(task).setValue(taskObject)
                Toast.makeText(this, "Task Added Successfully", Toast.LENGTH_LONG).show()
            }
            else
            {
                taskReference.child(task).setValue(taskObject)

                Toast.makeText(this, "Task Added Successfully", Toast.LENGTH_LONG).show()
            }


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}