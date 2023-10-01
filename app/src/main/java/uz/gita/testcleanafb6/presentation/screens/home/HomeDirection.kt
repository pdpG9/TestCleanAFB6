package uz.gita.testcleanafb6.presentation.screens.home

import uz.gita.testcleanafb6.presentation.navigator.AppNavigator
import uz.gita.testcleanafb6.presentation.screens.home.HomeScreen
import uz.gita.testcleanafb6.presentation.screens.login.LoginDirection
import uz.gita.testcleanafb6.presentation.screens.login.LoginScreen
import uz.gita.testcleanafb6.presentation.screens.register.RegisterScreen
import javax.inject.Inject
import javax.inject.Singleton

interface HomeDirection {
    suspend fun moveToAddScreen()
    suspend fun moveToUpdateScreen()
    suspend fun logout()
}
@Singleton
class HomeDirectionImp @Inject constructor(private val appNavigator: AppNavigator):
    HomeDirection {
    override suspend fun moveToAddScreen() {

    }

    override suspend fun moveToUpdateScreen() {

    }

    override suspend fun logout() {
        appNavigator.navigateTo(LoginScreen())
    }


}