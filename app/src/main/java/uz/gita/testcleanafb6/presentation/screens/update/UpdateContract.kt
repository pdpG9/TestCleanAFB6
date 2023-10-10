package uz.gita.testcleanafb6.presentation.screens.update

import kotlinx.coroutines.flow.StateFlow

interface UpdateContract {

    interface ViewModel {

        val uiState : StateFlow<UiState>

        fun eventDispatchers(intent : Intent)

    }

    data class UiState(
        val deleteIconState : Boolean = false,
        val name : String = "" ,
        val phone : String = "" ,
        val error : String = "" ,
        val id : Int = 0
    )

    interface Intent  {
        data class EnteringName(
            val name : String
        ) : Intent
        data class EnteringPhone(
            val phone : String
        ) : Intent
        data class EnterId(
            val id : Int
        ) : Intent
        data class UpdateContact(
            val id : Int ,
            val name : String,
            val phone : String
        ) : Intent
        object MoveToMainScreen : Intent
    }

}