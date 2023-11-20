package com.example.chatukchak


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import java.util.EventListener



class MainActivity : AppCompatActivity() {
    private lateinit var itemrecyclerView: RecyclerView
    private lateinit var itemArrayList: ArrayList<Item>
    private lateinit var db: FirebaseFirestore
    private lateinit var myAdapter: MyAdapter
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemrecyclerView = findViewById(R.id.recyclerView)
        itemrecyclerView.layoutManager = LinearLayoutManager(this)


        itemArrayList = arrayListOf()
        db = FirebaseFirestore.getInstance()
        db.collection("items").get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    for (data in it.documents) {
                        val item: Item? = data.toObject(Item::class.java)
                        if (item != null) {
                            itemArrayList.add(item)
                        }
                    }
                    itemrecyclerView.adapter = MyAdapter(itemArrayList)
                }
            }
            .addOnFailureListener { Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show() }
        btnLogout = findViewById(R.id.Logout)
        btnLogout.setOnClickListener {
            Firebase.auth.signOut()
            finish()
        }
    }
}









