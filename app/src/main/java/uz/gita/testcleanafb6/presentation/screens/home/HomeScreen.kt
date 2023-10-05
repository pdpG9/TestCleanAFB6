package uz.gita.testcleanafb6.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
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
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.testcleanafb6.R

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

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(56.dp)
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Contacts")
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = {
                    onEventDispatcher.invoke(HomeContract.Intent.LogOut)
                },
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_logout),
                        contentDescription = "Logout"
                    )
                },
            )
        }
        LazyColumn {
            items(uiState.value.contacts) {
                Text(text = it.name, style = MaterialTheme.typography.bodyLarge)
            }
        }
        FloatingActionButton(onClick = {

        }) {
            Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "Add")
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun HomeScreenPrev() {
    HomeScreenContent(mutableStateOf(HomeContract.UiState())) {}
}