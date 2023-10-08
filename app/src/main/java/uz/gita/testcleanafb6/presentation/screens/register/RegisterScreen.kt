package uz.gita.testcleanafb6.presentation.screens.register

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreenContent(
    uiState: State<RegisterContract.UiState>,
    onEventDispatcher: (RegisterContract.Intent) -> Unit
) {
    AppConfiguration.statusBarColor.value = BaseColor.toArgb()


    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
        ){
            Image(
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(141.dp)
                    .height(130.dp),
                painter = painterResource(id = R.drawable.ic_register_screen),
                contentDescription = "register icon"
            )
        }
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ){
            Column (
                modifier = Modifier
                    .align(Alignment.TopCenter) ,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                OutlinedTextField(
                    modifier = Modifier
                        .width(310.dp)
                        .height(58.dp) ,
                    value = "",
                    onValueChange = {} ,
                    trailingIcon = {
                        IconButton(onClick = {  }) {
                            Icon(
                                modifier = Modifier
                                    .width(17.dp)
                                    .height(17.dp),
                                painter = painterResource(id = R.drawable.ic_delete_words_edit_screem),
                                contentDescription = "delete word icon" ,
                                tint = Color(0xFF8E8E93)
                            )
                        }
                    } ,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.LightGray,
                        unfocusedBorderColor = Color.LightGray,
                    ),
                    shape = RoundedCornerShape(5.dp)
                )
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .width(310.dp)
                        .height(58.dp),
                    value = "Password",
                    onValueChange = {} ,
                    trailingIcon = {
                        IconButton(onClick = {  }) {
                            Icon(
                                modifier = Modifier
                                    .width(17.dp)
                                    .height(17.dp),
                                painter = painterResource(id = R.drawable.ic_eye),
                                contentDescription = "delete word icon" ,
                                tint = Color(0xFF8E8E93)
                            )
                        }
                    } ,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.LightGray ,
                        unfocusedBorderColor = Color.LightGray
                    ) ,
                    shape = RoundedCornerShape(5.dp)
                )
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .width(310.dp)
                        .height(58.dp),
                    value = "Confirm Password",
                    onValueChange = {} ,
                    trailingIcon = {
                        IconButton(onClick = {  }) {
                            Icon(
                                modifier = Modifier
                                    .width(17.dp)
                                    .height(17.dp),
                                painter = painterResource(id = R.drawable.ic_eye),
                                contentDescription = "delete word icon" ,
                                tint = Color(0xFF8E8E93)
                            )
                        }
                    } ,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.LightGray ,
                        unfocusedBorderColor = Color.LightGray
                    ) ,
                    shape = RoundedCornerShape(5.dp)
                )
                Button(
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .width(310.dp)
                        .height(50.dp) ,
                    onClick = {

                    } ,
                    shape = RoundedCornerShape(10.dp) ,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFEB5757)
                    )
                ) {
                    Text(
                        text = "Register" ,
                        style = TextStyle(
                            fontSize = 18.sp ,
                            fontFamily = FontFamily(listOf(Font(R.font.roboto_regular))) ,
                            fontWeight = FontWeight.W400 ,
                            textAlign = TextAlign.Center
                        )
                    )
                }
                Row (
                    modifier = Modifier
                        .padding(top = 25.dp)
                ){
                    Text(
                        text = "Do you have an account?" ,
                        style = TextStyle(
                            fontSize = 14.sp ,
                            lineHeight = 22.sp ,
                            fontFamily = FontFamily(listOf(Font(R.font.roboto_regular))) ,
                            fontWeight = FontWeight.W400 ,
                            color = Color(0xFF8E8E93)
                        )
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 5.dp) ,
                        text = "Log in" ,
                        style = TextStyle(
                            fontSize = 14.sp ,
                            lineHeight = 22.sp ,
                            fontFamily = FontFamily(listOf(Font(R.font.roboto))) ,
                            fontWeight = FontWeight.W700 ,
                            color = Color(0xFF8E8E93)
                        )
                    )
                }
            }
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