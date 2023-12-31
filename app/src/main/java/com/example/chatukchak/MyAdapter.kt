package com.example.chatukchak

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

/*
class MyAdapter: RecyclerView.Adapter<MyAdapter.ViewHolder>() {
        private var items: List<Item> = emptyList()
        fun setItems(items:List<Item>){
            this.items = items
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

            //holder.name.text = item.name
            //holder.description.text = item.description
            //holder.price.text = item.price.toString()
            //Glide.with(itemView.context).load(item.photoUrl).into(holder.itemImg)


    }

    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.nameContent)
        private val description: TextView = itemView.findViewById(R.id.descriptionContent)
        private val price: TextView = itemView.findViewById(R.id.priceContent)
        private val itemImg: ImageView = itemView.findViewById(R.id.ImgView)

        fun bind(item: Item) {
            name.text = "${item.name}"
            description.text = "${item.description}"
            price.text = item.price.toString()

            if (!item.photoUrl.isNullOrBlank()) {
                Glide.with(itemView.context).load(item.photoUrl).into(itemImg)
            }

        }
    }
}
*/

class MyAdapter(private val itemList: ArrayList<Item>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.nameContent)
        val description : TextView= itemView.findViewById(R.id.descriptionContent)
        val price : TextView= itemView.findViewById(R.id.priceContent)
        val itemImg : ImageView = itemView.findViewById(R.id.itemImg)
        val item_layout : CardView = itemView.findViewById(R.id.item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {

        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.item,
            parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item: Item= itemList[position]
        holder.name.text = itemList[position].name
        holder.description.text = itemList[position].description
        holder.price.text = itemList[position].price.toString()
        Picasso.get().load(itemList[position].photoUrl).into(holder.itemImg)


        val cont = holder.item_layout.context
        holder.item_layout.setOnClickListener{
            val intent = Intent(it.context,ViewActivity::class.java)
            makeText(cont,"The item ${itemList[position].name} is clicked", LENGTH_SHORT).show()

            intent.putExtra("itemImgUrl",itemList[position].photoUrl)
            intent.putExtra("name",itemList[position].name)
            intent.putExtra("description",itemList[position].description)
            intent.putExtra("price",itemList[position].price.toString())

            it.context.startActivity(intent)
        }
        holder.item_layout.setOnLongClickListener(View.OnLongClickListener {makeText(cont,"The item ${itemList[position].name} is long clicked",
            Toast.LENGTH_SHORT).show()
        return@OnLongClickListener true
        })}
        //Glide.with(context).load(itemList[position].photoUrl).into(holder.itemImg)


    override fun getItemCount(): Int {
        return itemList.size
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
}
*/