package com.firstaap.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter (val userList: ArrayList<user>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        val currentUser = userList.get(position)
        holder.tvName.text = currentUser.name
        holder.tvMobile.text = currentUser.mobile

        Glide
            .with(holder.ivUser)
            .load(currentUser.profileUrl)
            .placeholder(R.drawable.loading)
            .into( holder.ivUser)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvMobile: TextView = itemView.findViewById(R.id.tvMobile)
        val ivUser: ImageView = itemView.findViewById(R.id.ivUser)

    }
}