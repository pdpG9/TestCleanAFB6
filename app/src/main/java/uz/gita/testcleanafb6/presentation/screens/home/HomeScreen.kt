package uz.gita.testcleanafb6.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen

class HomeScreen:AndroidScreen() {
    @Composable
    override fun Content() {

        HomeScreenContent()
    }
}

@Composable
fun HomeScreenContent() {

}

@Composable
@Preview(showBackground = true)
fun HomeScreenPrev() {
    HomeScreenContent()
}