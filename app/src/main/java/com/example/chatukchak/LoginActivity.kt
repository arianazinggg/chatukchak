package com.example.chatukchak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.content.Intent
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var btnSignUp: Button
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnSignUp = findViewById(R.id.button5)
        btnSignUp.setOnClickListener {
            Log.d("ZZZTEST", "Clicked Login")
            var nextActivity: Intent
            nextActivity = Intent(this, MainActivity::class.java)
            startActivity(nextActivity)
        }
    }
}