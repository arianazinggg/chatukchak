package com.example.chatukchak


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatukchak.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity:AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var db: FirebaseFirestore

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        fun loadAllData(userID: String) {

            val itemList = ArrayList<Item>()

            db.collection("items").get()
                .addOnSuccessListener {
                    if (it.isEmpty) {
                        Toast.makeText(this@MainActivity, "No Item Found", Toast.LENGTH_SHORT)
                            .show()
                        return@addOnSuccessListener
                    }
                    for (doc in it) {
                        val item = doc.toObject(Item::class.java)
                        itemList.add(item)
                    }

                    binding.recyclerView.apply {
                        layoutManager =
                            LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
                        adapter = MyAdapter(itemList, this@MainActivity)
                    }

                }

        }


    }
}

/*

class MainActivity : AppCompatActivity() {
    lateinit var itemrecyclerView: RecyclerView
    private lateinit var itemList: ArrayList<Item>
    private lateinit var db: FirebaseFirestore
    private lateinit var myAdapter: MyAdapter
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemrecyclerView = findViewById(R.id.recyclerView)
        itemrecyclerView.setHasFixedSize(true)
        itemrecyclerView.layoutManager = LinearLayoutManager(this)

        itemList = arrayListOf()
        db = FirebaseFirestore.getInstance()
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

        /*

        itemList = ArrayList()
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

        btnLogout = findViewById(R.id.Logout)
        btnLogout.setOnClickListener {
            Firebase.auth.signOut()
            finish()*/
        }
    }

*/








