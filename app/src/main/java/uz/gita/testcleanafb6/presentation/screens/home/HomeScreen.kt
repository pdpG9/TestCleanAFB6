package uz.gita.testcleanafb6.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
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
import uz.gita.testcleanafb6.presentation.components.ContactItem

class HomeScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val vm: HomeContract.ViewModel = getViewModel<HomeViewModel>()

        when (vm.sideEffect.collectAsState().value) {
            HomeContract.SideEffect.Init -> {}
            HomeContract.SideEffect.LogOutDialog -> {}
        }
        HomeScreenContent(vm.uiState.collectAsState(), vm::onEventDispatcher)
    }
}

@Composable
fun HomeScreenContent(
    uiState: State<HomeContract.UiState>,
    onEventDispatcher: (HomeContract.Intent) -> Unit
) {

    Box (
        modifier = Modifier
            .fillMaxSize()
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
        ){
            Box (
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text(
                    modifier = Modifier
                        .padding(start = 18.dp , top = 13.dp) ,
                    text = "My Contacts" ,
                    style = TextStyle(
                        color = Color(0xFF8E8E93) ,
                        fontSize = 24.sp ,
                        fontFamily = FontFamily(listOf(Font(R.font.roboto))),
                        fontWeight = FontWeight.W700
                    )
                )
                Image(
                    modifier = Modifier
                        .padding(end = 18.dp, top = 11.33.dp)
                        .width(32.dp)
                        .height(32.dp)
                        .align(Alignment.TopEnd) ,
                    painter = painterResource(id = R.drawable.ic_logout_home_screen),
                    contentDescription = "home logout"
                )
            }
            LazyColumn {

            }
        }
        Column (
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 21.dp, bottom = 25.dp)
                .width(66.dp)
                .height(66.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFFEB5757))
                .padding(1.dp)
        ){
            Image(
                modifier = Modifier
                    .fillMaxSize() ,
                painter = painterResource(id = R.drawable.ic_add_home_screen),
                contentDescription = "home add icon"
            )
        }
    }

}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun HomeScreenPrev() {
    HomeScreenContent(mutableStateOf(HomeContract.UiState())) {}
}