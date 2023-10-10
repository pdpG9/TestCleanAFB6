package uz.gita.testcleanafb6.presentation.screens.update

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.gita.testcleanafb6.domain.usecase.UpdateContactUseCase
import javax.inject.Inject

@HiltViewModel
class UpdateViewModelImpl @Inject constructor(
    private val updateDirection: UpdateDirection ,
    private val updateContactUseCase: UpdateContactUseCase
) : UpdateContract.ViewModel , ViewModel(){
    override val uiState = MutableStateFlow<UpdateContract.UiState>(UpdateContract.UiState())

    override fun eventDispatchers(intent: UpdateContract.Intent) {
        when(intent) {
            is UpdateContract.Intent.EnteringName -> {
                reduce { it.copy(name = intent.name) }
            }
            is UpdateContract.Intent.EnteringPhone -> {
                reduce { it.copy(phone = intent.phone) }
            }
            is UpdateContract.Intent.EnterId -> {
                reduce { it.copy(id = intent.id) }
            }
            is UpdateContract.Intent.UpdateContact -> {
                updateContactUseCase.invoke(intent.id , intent.name , intent.phone)
            }
            UpdateContract.Intent.MoveToMainScreen -> {
                viewModelScope.launch {
                    updateDirection.back()
                }
            }
        }
    }

    private fun reduce(block : (UpdateContract.UiState) -> UpdateContract.UiState) {
        val old = uiState.value
        uiState.value = block(old)
    }
}