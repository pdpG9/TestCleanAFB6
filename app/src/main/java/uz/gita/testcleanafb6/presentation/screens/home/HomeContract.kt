package uz.gita.testcleanafb6.presentation.screens.home

import kotlinx.coroutines.flow.StateFlow
import uz.gita.testcleanafb6.domain.models.ContactParam

interface HomeContract {
    interface ViewModel{
        val uiState:StateFlow<UiState>
        val sideEffect:StateFlow<SideEffect>
        fun onEventDispatcher(intent: Intent)

    }
    data class UiState(
        val contacts:List<ContactParam> = emptyList(),
        val progress:Boolean = false,
    )
    interface SideEffect{
        object DeleteDialog:SideEffect
        object Init:SideEffect
        object LogOutDialog:SideEffect
        object DeleteAccountDialog:SideEffect

    }
    interface Intent{
        data class MoveToUpdateScreen(val contactParam: ContactParam):Intent
        object MoveToAddScreen:Intent
        data class DeleteContact(val contactParam: ContactParam):Intent
        object LogOut:Intent
        object DeleteAccount:Intent
        object InitState:Intent
    }
}