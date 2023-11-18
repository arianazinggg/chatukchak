package com.example.chatukchak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.content.Intent

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var btnLogin: Button
        lateinit var btnRegister: Button
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Log.d("ZZZTEST", "Called on Create")
        btnLogin = findViewById(R.id.button5)
        btnLogin.setOnClickListener {
            Log.d("ZZZTEST", "Clicked Signup")
            var nextActivity: Intent
            nextActivity = Intent(this, MainActivity::class.java)
            startActivity(nextActivity)

        }
        btnRegister = findViewById(R.id.button6)
        btnRegister.setOnClickListener {
        Log.d("ZZZTEST", "Clicked Register")
        val regis: Intent
        regis = Intent(this, RegistrationActivity::class.java)
        startActivity(regis)
        }
    }
}