package uz.gita.testcleanafb6.presentation.screens.register

import android.annotation.SuppressLint
import android.util.Log
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
import uz.gita.testcleanafb6.presentation.screens.login.LoginScreenContent
import uz.gita.testcleanafb6.ui.theme.AppConfiguration
import uz.gita.testcleanafb6.ui.theme.BaseColor

class RegisterScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val vm: RegisterContract.ViewModel = getViewModel<RegisterViewModel>()
        RegisterScreenContent(
            uiState = vm.uiState.collectAsState(),
            onEventDispatcher = vm::onEventDispatcher
        )

    }
}

@Composable
fun RegisterScreenContent(
    uiState: State<RegisterContract.UiState>,
    onEventDispatcher: (RegisterContract.Intent) -> Unit
) {
    AppConfiguration.statusBarColor.value = BaseColor.toArgb()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        GetVerticalSpaceLarge()
        Text(
            text = "Register",
            style = MaterialTheme.typography.displayLarge.copy(color = BaseColor),
            modifier = Modifier.align(CenterHorizontally)
        )
        GetVerticalSpaceLarge()
        EditTextField(labelText = "Name",
            value = uiState.value.name,
            trailIcon = {},
            paddingHorizontal = 16.dp,
            onValueChanged = { onEventDispatcher.invoke(RegisterContract.Intent.EnteringName(it)) }
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
                        onEventDispatcher.invoke(RegisterContract.Intent.ClickPasswordEye)
                    }
                )
            },
            visualTransformation = if (uiState.value.showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            paddingHorizontal = 16.dp,
            onValueChanged = { onEventDispatcher.invoke(RegisterContract.Intent.EnteringPassword(it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        GetVerticalSpaceSmall()
        EditTextField(
            labelText = "Confirm Password",
            value = uiState.value.confirmPassword,
            trailIcon = {
                Icon(
                    painter = painterResource(id = if (uiState.value.showPassword) R.drawable.ic_eye else R.drawable.ic_remove_eye),
                    contentDescription = "Password show",
                    modifier = Modifier.clickable {
                        onEventDispatcher.invoke(RegisterContract.Intent.ClickPasswordEye)
                    }
                )
            },
            visualTransformation = if (uiState.value.showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            paddingHorizontal = 16.dp,
            onValueChanged = { onEventDispatcher.invoke(RegisterContract.Intent.EnteringConfirmPassword(it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        GetVerticalSpaceSmall()
        CustomButton(
            text = "Register", buttonState = uiState.value.buttonState,
            horizontalPadding = 16.dp,
            progressAlpha = if (uiState.value.progress) 1f else 0f
        ) {

        }
        GetVerticalSpaceSmall()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Do you have an account? ",
                style = MaterialTheme.typography.labelSmall
            )
            Text(text = "Login",
                style = MaterialTheme.typography.labelSmall.copy(color = Color.Blue),
                modifier = Modifier.clickable { onEventDispatcher.invoke(RegisterContract.Intent.MoveToBack) })
        }

    }

}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun RegisterScreenPrev() {
    RegisterScreenContent(mutableStateOf(RegisterContract.UiState())) {

    }
}