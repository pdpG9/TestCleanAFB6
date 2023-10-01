package uz.gita.testcleanafb6.presentation.screens.login

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.testcleanafb6.R
import uz.gita.testcleanafb6.presentation.components.CustomButton
import uz.gita.testcleanafb6.presentation.components.EditTextField
import uz.gita.testcleanafb6.presentation.components.GetVerticalSpaceLarge
import uz.gita.testcleanafb6.presentation.components.GetVerticalSpaceSmall
import uz.gita.testcleanafb6.ui.theme.AppConfiguration
import uz.gita.testcleanafb6.ui.theme.BaseColor

class LoginScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        Log.d("TTT", "Content: ")
        val vm: LoginContract.ViewModel = getViewModel<LoginViewModel>()
        val sideEffect = vm.sideEffect.collectAsState()

         when(sideEffect.value){
             LoginContract.SideEffect.Init->{}
             is LoginContract.SideEffect.ShowToast->{
                 Toast.makeText(LocalContext.current,(sideEffect.value as LoginContract.SideEffect.ShowToast).message, Toast.LENGTH_SHORT).show()
             }
         }

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
    AppConfiguration.statusBarColor.value = BaseColor.toArgb()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        GetVerticalSpaceLarge()
        Text(
            text = "Login",
            style = MaterialTheme.typography.displayLarge.copy(color = BaseColor),
            modifier = Modifier.align(CenterHorizontally)
        )
        GetVerticalSpaceLarge()
        EditTextField(labelText = "Name",
            value = uiState.value.name,
            trailIcon = {},
            paddingHorizontal = 16.dp,
            onValueChanged = { onEventDispatcher.invoke(LoginContract.Intent.EnteringName(it)) }
        )
        GetVerticalSpaceSmall()
        EditTextField(
            labelText = "Password",
            value = uiState.value.password,
            trailIcon = {
                Icon(
                    painter = painterResource(id = if (uiState.value.showPassword) R.drawable.ic_eye else R.drawable.ic_remove_eye),
                    contentDescription = "Password show",
                    modifier = Modifier.clickable {
                        onEventDispatcher.invoke(LoginContract.Intent.ClickPasswordEye)
                    }
                )
            },
            visualTransformation = if (uiState.value.showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            paddingHorizontal = 16.dp,
            onValueChanged = { onEventDispatcher.invoke(LoginContract.Intent.EnteringPassword(it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        GetVerticalSpaceSmall()
        CustomButton(
            text = "Login", buttonState = uiState.value.buttonState,
            horizontalPadding = 16.dp,
            progressAlpha = if (uiState.value.progress) 1f else 0f
        ) { onEventDispatcher(LoginContract.Intent.Login) }
        GetVerticalSpaceSmall()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Don`t have an account? ",
                style = MaterialTheme.typography.labelSmall
            )
            Text(text = "Register",
                style = MaterialTheme.typography.labelSmall.copy(color = Color.Blue),
                modifier = Modifier.clickable { onEventDispatcher.invoke(LoginContract.Intent.MoveToRegister) })
        }

    }

}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun LoginScreenPrev() {
    LoginScreenContent(mutableStateOf(LoginContract.UiState())) {

    }
}