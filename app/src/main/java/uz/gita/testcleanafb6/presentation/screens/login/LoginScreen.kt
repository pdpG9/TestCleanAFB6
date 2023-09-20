package uz.gita.testcleanafb6.presentation.screens.login

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import org.koin.androidx.compose.getViewModel
import uz.gita.testcleanafb6.presentation.components.EditTextField

class LoginScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        Log.d("TTT", "Content: ")
        val vm: LoginContract.ViewModel = getViewModel<LoginViewModel>()

        LoginScreenContent(
            uiState = vm.uiState.collectAsState(),
            onEventDispatcher = vm::onEventDispatcher
        )

    }
}

@Composable
fun LoginScreenContent(
    uiState: State<LoginContract.UiState>,
    onEventDispatcher: (LoginContract.Intent) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        EditTextField(labelText = "Name", value = uiState.value.name,
            trailIcon = {},
            onValueChanged = { onEventDispatcher.invoke(LoginContract.Intent.EnteringName(it)) })
    }

}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun LoginScreenPrev() {
    LoginScreenContent(mutableStateOf(LoginContract.UiState())) {

    }
}