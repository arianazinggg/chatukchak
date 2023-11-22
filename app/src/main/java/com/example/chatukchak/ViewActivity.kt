package com.example.chatukchak

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val img_view = findViewById<ImageView>(R.id.imageView)
        val view_name: TextView = findViewById<TextView>(R.id.nameView)
        val view_description: TextView = findViewById<TextView>(R.id.descriptionView)
        val view_price: TextView = findViewById<TextView>(R.id.priceView)


        val itemImgUrl = intent.getStringExtra("itemImgUrl")
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val price = intent.getStringExtra("price")

        view_name.text = name
        view_description.text = description
        view_price.text = price
        Picasso.get().load(itemImgUrl).into(img_view)


    }
}