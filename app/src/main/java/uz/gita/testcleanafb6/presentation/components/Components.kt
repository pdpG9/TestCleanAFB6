package uz.gita.testcleanafb6.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import uz.gita.testcleanafb6.ui.theme.BaseColor
import uz.gita.testcleanafb6.ui.theme.TextFieldColor
import uz.gita.testcleanafb6.ui.theme.buttonColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(
    labelText: String,
    value: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailIcon :@Composable ()->Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    onValueChanged: (String) -> Unit
) {
    TextField(
        modifier = Modifier.padding(vertical = 8.dp)
            .height(56.dp)
            .fillMaxWidth(),
        placeholder = { Text(text = labelText) },
        keyboardOptions = keyboardOptions,
        value = value,
        onValueChange = onValueChanged,
        colors = TextFieldDefaults.textFieldColors(
            textColor = BaseColor,
            containerColor = TextFieldColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledLabelColor = Color.LightGray,
            cursorColor = BaseColor
        ),
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
        visualTransformation = visualTransformation,
        trailingIcon = trailIcon

    )
}

@Composable
fun CustomButton(
    text: String,
    buttonState: Boolean,
    progressAlpha: Float,
    block: () -> Unit
) {
    Button(
        onClick = { block.invoke() },
        enabled = buttonState,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = buttonColor, disabledContainerColor = BaseColor
        ),
        shape = RoundedCornerShape(12.dp), modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd) {
            Text(modifier = Modifier.fillMaxWidth(), text = text, style = MaterialTheme.typography.labelMedium)
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier
                    .padding(4.dp)
                    .height(30.dp)
                    .alpha(progressAlpha)
            )
        }
    }
}
