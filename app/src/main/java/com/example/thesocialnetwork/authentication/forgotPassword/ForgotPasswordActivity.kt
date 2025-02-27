package com.example.thesocialnetwork.authentication.forgotPassword

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thesocialnetwork.R

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val forgotPassword = findViewById<Button>(R.id.recoverPasswordButton)
        forgotPassword.setOnClickListener {
            Toast.makeText(this, "Hola Mundo", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT).show()

    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "On Pause", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "On Destroy", Toast.LENGTH_SHORT).show()
    }

}