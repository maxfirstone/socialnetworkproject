package com.example.aprendiendoxml2.authentication.login


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.aprendiendoxml2.R
import com.example.aprendiendoxml2.searchFriends.SearchFriends
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener { handleLogin() }

        lifecycleScope.launch {
            viewModel.state.collectLatest {
                if (it.isSuccess) {
                    Toast.makeText(
                        this@LoginActivity,
                        getString(R.string.feat_login_CredentialsCorrect),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                it.error?.let {
                    Toast.makeText(
                        this@LoginActivity,
                        getString(R.string.feat_login_incorrectCredentials),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    private fun handleLogin() {
        val emailField = findViewById<TextInputEditText>(R.id.email)
        val passwordField = findViewById<TextInputEditText>(R.id.password)

        val email = emailField.text.toString()
        val password = passwordField.text.toString()

        viewModel.login(email, password)
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

