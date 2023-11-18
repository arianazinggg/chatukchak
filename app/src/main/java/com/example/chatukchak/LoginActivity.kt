package com.example.chatukchak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.content.Intent
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var btnLogin: Button
        lateinit var btnRegister: Button
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.button5)
        btnLogin.setOnClickListener {
            Log.d("ZZZTEST", "Clicked Login")
            var nextActivity: Intent
            nextActivity = Intent(this, MainActivity::class.java)
            startActivity(nextActivity)

        }
        btnRegister.setOnClickListener {
        btnRegister = findViewById(R.id.button6)
        Log.d("ZZZTEST", "Clicked Register")
        var Regis: Intent
        Regis = Intent(this, RegistrationActivity::class.java)
        startActivity(Regis)
        }
    }
}