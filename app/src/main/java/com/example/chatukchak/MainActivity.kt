package com.example.chatukchak

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore


/*
class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)

        }
        fetchData()
}
    private fun fetchData(){
        FirebaseFirestore.getInstance().collection("items")
            .get()
            .addOnSuccessListener {
                documents->
                    for (document in documents){
                        val item =documents.toObjects(Item::class.java)
                        binding.recyclerView.adapter=MyAdapter(this,item)
                    }
            }
            .addOnFailureListener{ Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show() }

            }
            }


*/


/*
class MainActivity: AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter
    lateinit var btnLogout: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = MyAdapter()
        //recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //itemList = arrayListOf()
        val db = Firebase.firestore

        db.collection("items").get()
            .addOnSuccessListener {result->
                val items = mutableListOf<Item>()
                for (document in result){
                    val item = Item(
                        document.getString("name"),
                        document.getString("description"),
                        document.getLong("price"),
                        document.getString("photoUrl")
                    )
                    items.add(item)
                    Log.d(TAG,"${document.id}=> ${document.data}")
                }
                adapter.setItems(items)
                }
            .addOnFailureListener{
                exception-> Log.w(TAG,"Error getting documents",exception)
            }


        btnLogout = findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener {
            Firebase.auth.signOut()
            finish()
        }
    }
}
*/



class MainActivity : AppCompatActivity() {
    private lateinit var itemrecyclerView: RecyclerView
    private var itemList: ArrayList<Item> = ArrayList()
    private var db = Firebase.firestore
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemrecyclerView = findViewById(R.id.recyclerView)
        itemrecyclerView.setHasFixedSize(true)
        itemrecyclerView.layoutManager = LinearLayoutManager(this)
/*
        db = FirebaseFirestore.getInstance()
        db = FirebaseFirestore.getInstance()
        db.collection("items").get()
            .addOnSuccessListener {
                val itemList = mutableListOf<Item>()
                if (!it.isEmpty) {
                    for (data in it.documents) {
                        val item: Item? = data.toObject(Item::class.java)
                        if (item != null) {
                            itemList.add(item)
                        }
                        myAdapter.setItems(itemList)
                    }
                }
            }
            .addOnFailureListener { Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show() }

    */
        db = FirebaseFirestore.getInstance()
        db.collection("items").get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    for (data in it.documents) {
                        val item: Item? = data.toObject(Item::class.java)
                        if (item != null) {
                            itemList.add(item)
                        }
                    }
                    itemrecyclerView.adapter = MyAdapter(itemList)
                }
            }
            .addOnFailureListener { Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show() }

        btnLogout = findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener {
            Firebase.auth.signOut()
            finish()
        }
    }
}


