package uz.gita.testcleanafb6.presentation.screens.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel : ViewModel(), LoginContract.ViewModel {
    override val uiState = MutableStateFlow<LoginContract.UiState>(LoginContract.UiState())

    override fun onEventDispatcher(intent: LoginContract.Intent) {
        when (intent) {
            LoginContract.Intent.Login -> {

            }
            LoginContract.Intent.MoveToRegister -> {

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