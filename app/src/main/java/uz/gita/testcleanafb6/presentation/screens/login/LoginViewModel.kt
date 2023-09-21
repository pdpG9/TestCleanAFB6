package uz.gita.testcleanafb6.presentation.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val direction: LoginDirection) : ViewModel(), LoginContract.ViewModel {
    override val uiState = MutableStateFlow<LoginContract.UiState>(LoginContract.UiState())

    override fun onEventDispatcher(intent: LoginContract.Intent) {
        when (intent) {
            LoginContract.Intent.Login -> {

            }
            LoginContract.Intent.MoveToRegister -> {
                viewModelScope.launch {
                direction.moveToRegisterScreen()
                }
            }
            LoginContract.Intent.ClickPasswordEye->{
                reduce { it.copy(showPassword = !uiState.value.showPassword) }
            }

            is LoginContract.Intent.EnteringName -> {
                reduce { it.copy(name = intent.name) }
            }

            is LoginContract.Intent.EnteringPassword -> {
                reduce { it.copy(password = intent.password) }
            }
        }
    }

    private fun reduce(block: (oldState: LoginContract.UiState) -> LoginContract.UiState) {
        val old = uiState.value
        uiState.value = block(old)
    }
}