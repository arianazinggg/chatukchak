package com.example.chatukchak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import android.graphics.drawable.ColorDrawable
import android.util.Patterns
import androidx.appcompat.app.AlertDialog
import com.example.chatukchak.databinding.ActivityLoginBinding
class LoginActivity: AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
/*
    lateinit var mAuth: FirebaseAuth
    lateinit var btnLogin: Button
    lateinit var btnRegister: Button

    lateinit var etEmail: EditText
    lateinit var etPassw: EditText
    */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            val login_email = binding.loginemail.text.toString()
            val login_password = binding.loginpassw.text.toString()
            if (login_email.isNotEmpty() && login_password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(login_email, login_password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnRegister.setOnClickListener {
            val regisIntent = Intent(this, RegistrationActivity::class.java)
            startActivity(regisIntent)
            }
        }
    }

/*
        etEmail = findViewById(R.id.loginemail)
        etPassw = findViewById(R.id.loginpassw)
        btnLogin.setOnClickListener {

            var val_email = etEmail.text.toString()
            var val_passw = etPassw.text.toString()

            if(val_email.equals("")||val_passw.equals("")){
                Toast.makeText(this, "Required fields", Toast.LENGTH_SHORT)

            }else{
                signInEmailPass(val_email, val_passw)

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

    override fun onStart() {
        super.onStart()

        val currentUser = mAuth.currentUser
        if (currentUser != null) {
            updateUI(currentUser)
        }
    }

    fun signInEmailPass(email: String, passw: String) {
        var Tag = "ZZZTagFirebase"
        mAuth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                Log.d(Tag, "signInWithEmail:success")
                val user = mAuth.currentUser
            } else {
                Log.w(Tag, "signInWithEmail:failure", task.exception)
                Toast.makeText(
                    baseContext,
                    "Authentication failed",
                    Toast.LENGTH_SHORT,
                ).show()
                updateUI(null)
            }
        }
    }
    fun updateUI(user: FirebaseUser?){

        if(user != null){
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(
                baseContext,
                "You did not login",
                Toast.LENGTH_SHORT,
            ).show()
            updateUI(user)
        }




        /*mAuth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(this, OnCompleteListener<AuthResult> {
            @Override
            fun onComplete(result: Task<AuthResult>){
                if(result.isComplete()){
                    Log.d(Tag, "Success signin")
                    Toast.makeText(this, "Success signin", Toast.LENGTH_LONG)
                }else if (result.isSuccessful){
                    Log.d(Tag, "Success signin")
                    Toast.makeText(this, "Success signin", Toast.LENGTH_LONG)
                }else{
                    Log.d(Tag, "not successful")
                    Toast.makeText(this, "Not signin", Toast.LENGTH_LONG)
                }
            }

        })*/
    }
}
*/
