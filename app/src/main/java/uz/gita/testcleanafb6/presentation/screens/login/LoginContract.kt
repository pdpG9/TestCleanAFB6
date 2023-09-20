package uz.gita.testcleanafb6.presentation.screens.login

import kotlinx.coroutines.flow.StateFlow

interface LoginContract {
    data class UiState(
        val buttonState: Boolean = false,
        val progress: Boolean = false,
        val errorMessage: String = "",
        val name: String = "",
        val password: String = ""
    )

    interface Intent {
        data class EnteringName(val name: String) : Intent
        data class EnteringPassword(val password: String) : Intent
        object Login : Intent
        object MoveToRegister : Intent
    }
    interface ViewModel{
        val uiState :StateFlow<UiState>
        fun onEventDispatcher(intent: Intent)
    }
}