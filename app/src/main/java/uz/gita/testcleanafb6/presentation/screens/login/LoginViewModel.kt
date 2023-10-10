package uz.gita.testcleanafb6.presentation.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.gita.testcleanafb6.domain.usecase.LoginUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val direction: LoginDirection,
    private val loginUseCase: LoginUseCase,
) : ViewModel(), LoginContract.ViewModel {
    override val uiState = MutableStateFlow<LoginContract.UiState>(LoginContract.UiState())
    override val sideEffect =
        MutableStateFlow<LoginContract.SideEffect>(LoginContract.SideEffect.Init)

    override fun onEventDispatcher(intent: LoginContract.Intent) {
        when (intent) {
            LoginContract.Intent.Login -> {
                loginUseCase.execute(uiState.value.name, uiState.value.password).onEach {
                    if (it.isSuccess) {
                        direction.moveToMainScreen()
                    }
                    sideEffect.emit(LoginContract.SideEffect.ShowToast(it.message))
                }.launchIn(viewModelScope)
            }

            LoginContract.Intent.MoveToRegister -> {
                viewModelScope.launch {
                    direction.moveToRegisterScreen()
                }
            }

            LoginContract.Intent.ClickPasswordEye -> {
                reduce { it.copy(showPassword = !uiState.value.showPassword) }
            }

            is LoginContract.Intent.EnteringName -> {
                reduce { it.copy(name = intent.name) }
            }

            is LoginContract.Intent.EnteringPassword -> {
                reduce { it.copy(password = intent.password) }
            }
        }
    }

    private fun reduce(block: (oldState: LoginContract.UiState) -> LoginContract.UiState) {
        val old = uiState.value
        uiState.value = block(old)
    }
}