package com.example.chatukchak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent


class MyAdapter(private val userList: ArrayList<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
   
    @InternalCoroutinesApi
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent,false)

        return MyViewHolder(itemView)
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user: User= userList[position]
        holder.Name.text= user.Name
        holder.Description.text = user.Description
        holder.Price.text = user.Price.toString()

        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return userList.size
    }
    public class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val Name: TextView = itemView.findViewById(R.id.Name)
        val Description: TextView = itemView.findViewById(R.id.Description)
        val Price: TextView = itemView.findViewById(R.id.price)}
}