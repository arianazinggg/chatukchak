package com.example.chatukchak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.content.Intent

class RegistrationActivity : AppCompatActivity() {
    lateinit var btnRegandLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnRegandLogin = findViewById(R.id.RegandLogin)
        btnRegandLogin.setOnClickListener {
            Log.d("ZZZTEST", "Clicked Login")
            var nextActivity: Intent
            nextActivity = Intent(this, MainActivity::class.java)
            startActivity(nextActivity)

        }
    }
}