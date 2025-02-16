package com.example.aprendiendoxml2.authentication.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aprendiendoxml2.authentication.shared.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class LoginState(
    val isSuccess: Boolean = false,
    val error: Throwable? = null
)

class LoginViewModel(
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state


    fun login(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _state.value = _state.value.copy(
                error = RuntimeException("Campos Vacios!")
            )
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                val token = authRepository.login(email.trim().lowercase(), password.trim())
                if (token == null) {
                    println("Error, the token is null")
                } else {
                    println("Token: $token")
                }
                println("HI COROUTINES")
            }
        }


    }
}
