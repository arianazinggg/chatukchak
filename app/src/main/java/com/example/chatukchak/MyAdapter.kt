package com.example.chatukchak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent


class MyAdapter(private val itemList: ArrayList<Item>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {

        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.activity_main,
            parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentitem = itemList[position]

        holder.name.text = currentitem.name
        holder.description.text = currentitem.description
        holder.price.text = currentitem.price.toString()
        Picasso.get().load(currentitem.photoUrl).into(holder.itemImg)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val name : TextView= itemView.findViewById(R.id.nameContent)
        val description : TextView= itemView.findViewById(R.id.descriptionContent)
        val price : TextView= itemView.findViewById(R.id.priceContent)
        val itemImg : ImageView = itemView.findViewById(R.id.itemImg)
    }

}

/*
class MyAdapter(private val userList: ArrayList<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
   
    @InternalCoroutinesApi
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent,false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user: User= userList[position]
        holder.Name.text= user.Name
        holder.Description.text = user.Description
        holder.Price.text = user.Price.toString()

    }

    override fun getItemCount(): Int {
        return userList.size
    }
    public class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val Name: TextView = itemView.findViewById(R.id.Name)
        val Description: TextView = itemView.findViewById(R.id.Description)
        val Price: TextView = itemView.findViewById(R.id.price)}
}*/