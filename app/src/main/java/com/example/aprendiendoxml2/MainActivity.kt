package com.example.aprendiendoxml2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aprendiendoxml2.feed.FeedActivity
import com.example.aprendiendoxml2.authentication.forgotPassword.ForgotPasswordActivity
import com.example.aprendiendoxml2.authentication.login.LoginActivity
import com.example.aprendiendoxml2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val irLogin = findViewById<Button>(R.id.login)
        irLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val irForgotPassword = findViewById<Button>(R.id.forgotPasswordButton)
        irForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        val feed = findViewById<Button>(R.id.feedButton)
        feed.setOnClickListener {
            val intent = Intent(this, FeedActivity::class.java)
            startActivity(intent)
        }

    }
}