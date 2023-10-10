package uz.gita.testcleanafb6.presentation.screens.register

import kotlinx.coroutines.flow.StateFlow

interface RegisterContract {
    data class UiState(
        val buttonState: Boolean = false,
        val progress: Boolean = false,
        val showPassword: Boolean = false,
        val errorMessage: String = "",
        val name: String = "",
        val password: String = "",
        val confirmPassword: String = "" ,
        val removeWordsButtonState : Boolean = false ,
        val isSameConfirmPassword : Boolean = true ,
        val checkLengthPassword : Boolean = false
    )

    interface Intent {
        data class EnteringName(val name: String) : Intent
        data class EnteringPassword(val password: String) : Intent
        data class EnteringConfirmPassword(val password: String) : Intent
        object Register : Intent
        object MoveToBack:Intent
        object AfterEnteringPassword : Intent
        object ClickPasswordEye : Intent
    }

    interface ViewModel {
        val uiState: StateFlow<UiState>
        fun onEventDispatcher(intent: Intent)
    }
}