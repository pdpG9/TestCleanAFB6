package uz.gita.testcleanafb6.presentation.screens.splesh

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import uz.gita.testcleanafb6.R
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
    AppConfiguration.statusBarColor.value = Color.White.toArgb()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.contact_icon),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .width(188.dp)
                .height(174.dp),
        )

        ComposeLottieAnimation(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun ComposeLottieAnimation(modifier: Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading_anim))

    LottieAnimation(
        modifier = modifier,
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )
}

@Composable
@Preview(showBackground = true)
fun SplashScreenPrev() {
    TestCleanAFB6Theme {
        SplashScreenContent()
    }
}
