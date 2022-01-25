package com.firstaap.todoapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class CustomAdapter(val taskList: ArrayList<Task>): RecyclerView.Adapter<CustomAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentTask = taskList.get(position)
        holder.tvTask.text = currentTask.taskName
        holder.tvDescription.text = currentTask.taskDescription

        if(currentTask.taskPriority.equals("Medium"))
        {
            holder.ivPriority.setImageResource(R.drawable.medium)
        }
        else if(currentTask.taskPriority.equals("High"))
        {
            holder.ivPriority.setImageResource(R.drawable.high)
        }
        else{
            holder.ivPriority.setImageResource(R.drawable.low)
        }
        holder.cardTask.setOnClickListener{
            val intent = Intent(holder.cardTask.context, AddTask::class.java)
            intent.putExtra("taskType", "update")
            intent.putExtra("taskName", currentTask.taskName)
            intent.putExtra("taskDescription", currentTask.taskDescription)
            intent.putExtra("taskPriority", currentTask.taskPriority)
            holder.cardTask.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardTask: CardView = itemView.findViewById(R.id.cardTask)
        val tvTask: TextView = itemView.findViewById(R.id.tvTask)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val ivPriority: ImageView = itemView.findViewById(R.id.ivPriority)
    }

}