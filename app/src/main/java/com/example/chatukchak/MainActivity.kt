package com.example.chatukchak


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import java.util.EventListener



class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<User>
    private lateinit var myAdapter:MyAdapter
    private lateinit var db: FirebaseFirestore

    private lateinit var btnLogout: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFizedSize(true)

        userArrayList = arrayListOf()
        myAdapter = MyAdapter(userArrayList)
        recyclerView.adapter = myAdapter

        EventChangeListener()


        btnLogout = findViewById(R.id.Logout)
        btnLogout.setOnClickListener {
            Firebase.auth.signOut()
            finish()
        }
    }

    private fun EventChangeListener() {
        db = FirebaseFirestore.getInstance()
        db.collection("Users").
            addSnapshotListener(object: com.google.firebase.firestore.EventListener<QuerySnapshot> {
                override fun onEvent(
                    value:QuerySnapshot?,
                    error: FirebaseFirestoreException?
                ){
                    if(error != null){
                        Log.e("Firestore Error" , error.message.toString())
                        return
                    }
                    for (dc: DocumentChange in value?.documentChanges!!){
                        if(dc.type==DocumentChange.Type.ADDED){
                            userArrayList.add(dc.document.toObject(User::class.java))
                        }
                    }
                    myAdapter.notifyDataSetChanged()
                }

            })
        TODO("Not yet implemented")
    }
}