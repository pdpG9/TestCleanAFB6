package uz.gita.testcleanafb6.presentation.screens.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val direction: RegisterDirection) : ViewModel(),
    RegisterContract.ViewModel {
    override val uiState = MutableStateFlow<RegisterContract.UiState>(RegisterContract.UiState())
    private var confirmPassword = ""

    override fun onEventDispatcher(intent: RegisterContract.Intent) {
        when (intent) {
            RegisterContract.Intent.Register -> {

            }

            RegisterContract.Intent.MoveToBack -> {
                viewModelScope.launch {
                    direction.back()
                }
            }

            RegisterContract.Intent.ClickPasswordEye -> {
                reduce { it.copy(showPassword = !uiState.value.showPassword) }
            }

            is RegisterContract.Intent.EnteringName -> {
                reduce { it.copy(name = intent.name) }
                reduce { it.copy(removeWordsButtonState = intent.name.isNotBlank()) }
            }

            is RegisterContract.Intent.EnteringPassword -> {
                confirmPassword = intent.password
                reduce { it.copy(password = confirmPassword) }
                reduce { it.copy(checkLengthPassword = confirmPassword.length < 5) }
            }

            is RegisterContract.Intent.EnteringConfirmPassword -> {
                reduce { it.copy(confirmPassword = intent.password) }
                reduce { it.copy(isSameConfirmPassword = intent.password == confirmPassword) }
            }
        }
    }

    private fun reduce(block: (oldState: RegisterContract.UiState) -> RegisterContract.UiState) {
        val old = uiState.value
        uiState.value = block(old)
    }
}