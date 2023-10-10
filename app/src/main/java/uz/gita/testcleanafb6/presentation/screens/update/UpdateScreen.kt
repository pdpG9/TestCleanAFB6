package uz.gita.testcleanafb6.presentation.screens.update

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.testcleanafb6.R
import uz.gita.testcleanafb6.domain.models.ContactParam

class UpdateScreen(
    private val contactParam: ContactParam
) : AndroidScreen(){
    @Composable
    override fun Content() {
        val viewModel : UpdateContract.ViewModel = getViewModel<UpdateViewModelImpl>()
        Log.d("TTT", "Content: ")
        viewModel.eventDispatchers(UpdateContract.Intent.EnterId(contactParam.data.id))
        viewModel.eventDispatchers(UpdateContract.Intent.EnteringName(contactParam.data.name))
        viewModel.eventDispatchers(UpdateContract.Intent.EnteringPhone(contactParam.data.phone))
        UpdateScreenContent(
            viewModel.uiState.collectAsState().value ,
            viewModel::eventDispatchers
        )
    }
}

@Composable
fun UpdateScreenContent(
    uiState : UpdateContract.UiState ,
    onEventDispatcher : (UpdateContract.Intent) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.9f)
        ){
            Image(
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(141.dp)
                    .height(141.dp),
                painter = painterResource(id = R.drawable.ic_main_edit_screen),
                contentDescription = "icon edit"
            )
        }
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ){
            Column (
                modifier = Modifier
                    .align(Alignment.TopCenter)
            ){
                OutlinedTextField(
                    modifier = Modifier
                        .width(310.dp)
                        .height(58.dp) ,
                    value = uiState.name,
                    onValueChange = {
                        onEventDispatcher.invoke(UpdateContract.Intent.EnteringName(it))
                    } ,
                    label = {
                        Text("name")
                    },
                    trailingIcon = {
                        if(uiState.name.isNotEmpty()) {
                            IconButton(onClick = {
                                onEventDispatcher.invoke(UpdateContract.Intent.EnteringName(""))
                            }) {
                                Icon(
                                    modifier = Modifier
                                        .width(17.dp)
                                        .height(17.dp) ,
                                    painter = painterResource(id = R.drawable.ic_delete_words_edit_screem),
                                    contentDescription = "delete words" ,
                                    tint = Color(0xff8E8E93)
                                )
                            }
                        }
                    } ,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.LightGray ,
                        unfocusedBorderColor = Color.LightGray
                    ) ,
                    textStyle = TextStyle(
                        color = Color(0xFF8E8E93) ,
                        fontWeight = FontWeight.W400 ,
                        fontFamily = FontFamily(listOf(Font(R.font.roboto_regular)))
                    )
                )
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .width(310.dp)
                        .height(58.dp),
                    value = uiState.phone,
                    onValueChange = {
                        onEventDispatcher.invoke(UpdateContract.Intent.EnteringPhone(it))
                    } ,
                    label = {
                        Text("phone")
                    } ,
                    trailingIcon = {
                        if (uiState.phone.isNotEmpty()) {
                            IconButton(onClick = {
                                onEventDispatcher.invoke(UpdateContract.Intent.EnteringPhone(""))
                            }) {
                                Icon(
                                    modifier = Modifier
                                        .width(17.dp)
                                        .height(17.dp) ,
                                    painter = painterResource(id = R.drawable.ic_delete_words_edit_screem),
                                    contentDescription = "" ,
                                    tint = Color(0xFF8E8E93)
                                )
                            }
                        }
                    } ,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.LightGray ,
                        unfocusedBorderColor = Color.LightGray
                    ) ,
                    textStyle = TextStyle(
                        color = Color(0xFF8E8E93) ,
                        fontWeight = FontWeight.W400 ,
                        fontFamily = FontFamily(listOf(Font(R.font.roboto_regular)))
                    )
                )
                Button(
                    modifier = Modifier
                        .padding(top = 51.dp)
                        .width(310.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFEB5757)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    onClick = {

                    }
                ) {
                    Text(
                        text = "Update" ,
                        style = TextStyle(
                            fontSize = 18.sp ,
                            fontFamily = FontFamily(Font(R.font.roboto_regular)) ,
                            fontWeight = FontWeight.W400
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UpdateScreenContentPreview() {
    UpdateScreenContent(
        UpdateContract.UiState()
    ){}
}