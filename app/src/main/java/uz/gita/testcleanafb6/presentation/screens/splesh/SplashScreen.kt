package uz.gita.testcleanafb6.presentation.screens.splesh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.testcleanafb6.ui.theme.AppConfiguration
import uz.gita.testcleanafb6.ui.theme.TestCleanAFB6Theme

class SplashScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        getViewModel<SplashViewModelImp>()
        SplashScreenContent()
    }
}

@Composable
fun SplashScreenContent() {
    AppConfiguration.statusBarColor.value = Color.Yellow.toArgb()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(
            text = "GITA",
            style = TextStyle(
                fontSize = 48.sp,
                fontWeight = FontWeight.W700,
                color = Color.Black
            ),
            modifier = Modifier.align(
                Alignment.Center
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun SplashScreenPrev() {
    TestCleanAFB6Theme {
        SplashScreenContent()
    }
}
