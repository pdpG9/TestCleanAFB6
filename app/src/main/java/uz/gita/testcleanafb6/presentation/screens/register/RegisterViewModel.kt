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
            }

            is RegisterContract.Intent.EnteringPassword -> {
                reduce { it.copy(password = intent.password) }
            }

            is RegisterContract.Intent.EnteringConfirmPassword -> {
                reduce { it.copy(confirmPassword = intent.password) }
            }
        }
    }

    private fun reduce(block: (oldState: RegisterContract.UiState) -> RegisterContract.UiState) {
        val old = uiState.value
        uiState.value = block(old)
    }
}