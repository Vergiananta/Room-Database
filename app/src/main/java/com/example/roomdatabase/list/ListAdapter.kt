package com.example.roomdatabase.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.data.User
import kotlinx.android.synthetic.main.profile_layout.view.*

class ListAdapter : RecyclerView.Adapter<ListHolder>() {

    private var userList = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return ListHolder(LayoutInflater.from(parent.context).inflate(R.layout.profile_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.id_number.text = currentItem.id.toString()
        holder.itemView.firstname.text = currentItem.firstName.toString()
        holder.itemView.lastname.text = currentItem.lastName.toString()
        holder.itemView.age.text = currentItem.age.toString()


    }

    override fun getItemCount() = userList.size

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}