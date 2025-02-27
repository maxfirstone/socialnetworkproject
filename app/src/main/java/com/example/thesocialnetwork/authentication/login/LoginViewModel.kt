package com.example.thesocialnetwork.authentication.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesocialnetwork.authentication.shared.AuthenticationModule
import com.example.thesocialnetwork.authentication.shared.repository.domain.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class LoginState(
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    val token: String? = null
)

class LoginViewModel(
    private val authRepository: AuthRepository = AuthenticationModule.provideRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state


    fun login(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            _state.value = _state.value.copy(
                error = RuntimeException("Ingresa los datos!")
            )
            return
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                _state.value = _state.value.copy(
                    isLoading = true
                )
                val token = authRepository.login(email.trim().lowercase(), password.trim())
                _state.value = _state.value.copy(
                    isLoading = false,
                    token = token,
                    error = if (token != null) {
                        null
                    } else {
                        RuntimeException("Error NO TOKEN")
                    }
                )
                if (token == null) {
                    println("Error, the token is null")
                } else {
                    println("Token: $token")
                }

                //println("HI COROUTINES") // Trying Debugging
            }
        }

    }
}
