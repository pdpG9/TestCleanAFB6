package uz.gita.testcleanafb6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.get
import uz.gita.testcleanafb6.presentation.navigator.NavigationHandler
import uz.gita.testcleanafb6.presentation.screens.login.LoginScreen
import uz.gita.testcleanafb6.presentation.screens.splesh.SplashScreen
import uz.gita.testcleanafb6.ui.theme.TestCleanAFB6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navigationHandler: NavigationHandler = get()
            TestCleanAFB6Theme {
                Navigator(screen = LoginScreen()) { navigator ->
                    LaunchedEffect(key1 = navigator) {
                        navigationHandler.navigationFlow
                            .onEach { it(navigator) }
                            .collect()
                    }
                    CurrentScreen()
                }
            }
        }
    }
}