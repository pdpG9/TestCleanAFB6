package uz.gita.testcleanafb6.presentation.screens.add

import kotlinx.coroutines.flow.StateFlow

interface AddContract {
    interface ViewModel{
        val uiState: StateFlow<AddContract.UiState>
        fun onEventDispatcher(intent: AddContract.Intent)
    }

    data class UiState(
        val buttonState : Boolean = true,
        val progress : Boolean = false,
        val error : String = "",
        val success : String = "",
        val name : String = "",
        val phone  :String = ""
    )
    interface Intent {

        data class EnteringName(val name : String) : Intent
        data class EnteringPhone(val phone: String) : Intent

        data class AddContact(val name: String, val phone: String) : Intent
        object MoveToMainScreen: Intent
    }
}