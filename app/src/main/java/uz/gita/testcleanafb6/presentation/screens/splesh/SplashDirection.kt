package uz.gita.testcleanafb6.presentation.screens.splesh

import uz.gita.testcleanafb6.presentation.navigator.AppNavigator
import uz.gita.testcleanafb6.presentation.screens.home.HomeScreen
import uz.gita.testcleanafb6.presentation.screens.login.LoginScreen
import uz.gita.testcleanafb6.presentation.screens.register.RegisterScreen
import javax.inject.Inject
import javax.inject.Singleton

interface SplashDirection {
    suspend fun moveToLoginScreen()
    suspend fun moveToMainScreen()
}
@Singleton
class SplashDirectionImp @Inject constructor(private val appNavigator: AppNavigator):SplashDirection{
    override suspend fun moveToLoginScreen() {
        appNavigator.navigateTo(LoginScreen())
    }

    override suspend fun moveToMainScreen() {
       appNavigator.replaceAll(HomeScreen())
    }

}