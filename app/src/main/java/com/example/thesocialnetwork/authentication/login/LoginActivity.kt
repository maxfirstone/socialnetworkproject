package com.example.thesocialnetwork.authentication.login


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.thesocialnetwork.MainActivity
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.databinding.ActivityLoginBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding
    //private var binding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val loginButton = findViewById<Button>(R.id.loginButton)
        binding.loginButton.setOnClickListener { handleLogin() }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest { state ->
                    invalidate(state)
                }
            }
        }


    }

    private fun invalidate(state: LoginState) {
        if (state.isLoading) {
            Toast.makeText(
                this,
                R.string.feat_login_loading,
                Toast.LENGTH_SHORT
            ).show()
        } else {
            // cancelar dialogo de cargando
            Toast.makeText(
                this,
                "No esta cargando",
                Toast.LENGTH_SHORT
            ).show()
        }
        if (state.error != null) {
            Toast.makeText(
                this,
                getString(R.string.feat_login_error, state.error.toString()),
                Toast.LENGTH_SHORT
            ).show()
        }
        if (state.token != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun handleLogin() {
        val email = binding.email.text.toString()
        val password = binding.password.text.toString()

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
}

