package uz.gita.testcleanafb6.presentation.screens.add

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.testcleanafb6.R
import uz.gita.testcleanafb6.presentation.components.CustomButton
import uz.gita.testcleanafb6.presentation.components.EditTextField
import uz.gita.testcleanafb6.presentation.components.TrailingIconView
import uz.gita.testcleanafb6.ui.theme.TestCleanAFB6Theme

class AddScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: AddContract.ViewModel = getViewModel<AddViewModel>()

        AddScreenContent(
            uiState = viewModel.uiState.collectAsState(),
            onEventDispatcher = viewModel::onEventDispatcher
        )
    }

}

@Composable
fun AddScreenContent(
    uiState: State<AddContract.UiState>,
    onEventDispatcher: (intent: AddContract.Intent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.addpic
            ),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 98.dp)
                .width(141.dp)
                .height(131.dp)
                .align(CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(98.dp))

        EditTextField(
            labelText = "Name",
            value = uiState.value.name,
            trailIcon = { if (uiState.value.name.isNotBlank()) TrailingIconView(text = "") else null },
            onValueChanged = { onEventDispatcher.invoke(AddContract.Intent.EnteringName(it)) },
            paddingHorizontal = 32.dp
        )

        Spacer(modifier = Modifier.height(24.dp))

        EditTextField(
            labelText = "Phone",
            value = uiState.value.phone,
            trailIcon = { if (uiState.value.name.isNotBlank()) TrailingIconView(text = "") else null },
            onValueChanged = { onEventDispatcher.invoke(AddContract.Intent.EnteringPhone(it)) },
            paddingHorizontal = 32.dp
        )

        Spacer(modifier = Modifier.height(51.dp))
        CustomButton(
            text = "Add",
            buttonState = uiState.value.buttonState,
            progressAlpha = if (uiState.value.progress) 1f else 0f,
            horizontalPadding = 32.dp
        ) {
            onEventDispatcher(AddContract.Intent.AddContact(uiState.value.name, uiState.value.phone))
            onEventDispatcher(AddContract.Intent.MoveToMainScreen)
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun AddScreenPreview() {
    TestCleanAFB6Theme {
        AddScreenContent(uiState = mutableStateOf(AddContract.UiState())) {}
    }
}