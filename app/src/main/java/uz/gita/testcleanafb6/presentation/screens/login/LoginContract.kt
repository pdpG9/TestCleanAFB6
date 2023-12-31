package uz.gita.testcleanafb6.presentation.screens.login

import kotlinx.coroutines.flow.StateFlow
import uz.gita.testcleanafb6.presentation.screens.home.HomeContract

interface LoginContract {
    data class UiState(
        val buttonState: Boolean = true,
        val progress: Boolean = false,
        val showPassword: Boolean = false,
        val errorMessage: String = "",
        val name: String = "",
        val password: String = ""
    )
    interface SideEffect{
        object Init: SideEffect
        data class ShowToast(val message:String = ""):SideEffect
    }

    interface Intent {
        data class EnteringName(val name: String) : Intent
        data class EnteringPassword(val password: String) : Intent
        object Login : Intent
        object MoveToRegister : Intent

        object ClickPasswordEye : Intent
    }

    interface ViewModel {
        val uiState: StateFlow<UiState>
        val sideEffect: StateFlow<SideEffect>
        fun onEventDispatcher(intent: Intent)
    }
}