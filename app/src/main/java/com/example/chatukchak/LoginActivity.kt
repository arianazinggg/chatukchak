package com.example.chatukchak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity: AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth

    lateinit var btnLogin: Button
    lateinit var btnRegister: Button

    lateinit var etEmail: EditText
    lateinit var etPassw: EditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        Log.d("ZZZTEST", "Called on Create")
        btnLogin = findViewById(R.id.button5)
        btnRegister = findViewById(R.id.button6)
        etEmail = findViewById(R.id.loginemail)
        etPassw = findViewById(R.id.loginpassw)
        btnLogin.setOnClickListener {

            var val_email = etEmail.text.toString()
            var val_passw = etPassw.text.toString()

            if(val_email.equals("")||val_passw.equals("")){
                Toast.makeText(this, "Required fields", Toast.LENGTH_SHORT)

            }else{

            }


            Log.d("ZZZTEST", "Clicked Signup")
            var nextActivity: Intent
            nextActivity = Intent(this, MainActivity::class.java)
            startActivity(nextActivity)

        }
        btnRegister.setOnClickListener {
        Log.d("ZZZTEST", "Clicked Register")
        val regis: Intent
        regis = Intent(this, RegistrationActivity::class.java)
        startActivity(regis)
        }
    }

    fun_sign
}