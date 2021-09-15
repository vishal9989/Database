package com.example.database1f

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mAuth = FirebaseAuth.getInstance()

        register.setOnClickListener(View.OnClickListener {
            val email = email.text.toString()
            val paswrd = password.text.toString()

            mAuth.createUserWithEmailAndPassword(email, paswrd).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "SUCCESS!!", Toast.LENGTH_SHORT).show()
                } 
                it.addOnFailureListener {
                    Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
                    Log.d("DEBUG", it.printStackTrace().toString())
                }
            }

        })
    }
}