package uz.gita.testcleanafb6.presentation.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.gita.testcleanafb6.domain.usecase.AddContactUseCase
import uz.gita.testcleanafb6.presentation.screens.login.LoginContract
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val direction: AddDirection,
    private val addContactUseCase: AddContactUseCase
) : ViewModel(), AddContract.ViewModel {
    override val uiState = MutableStateFlow(AddContract.UiState())

    override fun onEventDispatcher(intent: AddContract.Intent) {
        when (intent) {
            AddContract.Intent.MoveToMainScreen -> {
                viewModelScope.launch {
                    direction.moveToMainScreen()
                }
            }
            is AddContract.Intent.AddContact -> {
                addContactUseCase.addContact(intent.name, intent.phone).onEach {

                }.launchIn(viewModelScope)
            }
            is AddContract.Intent.EnteringName -> {
               reduce { it.copy(name = intent.name) }
            }
            is AddContract.Intent.EnteringPhone -> {
                reduce { it.copy(phone = intent.phone) }
            }
        }
    }

    private fun reduce(block: (oldState: AddContract.UiState) -> AddContract.UiState) {
        val old = uiState.value
        uiState.value = block(old)
    }

}