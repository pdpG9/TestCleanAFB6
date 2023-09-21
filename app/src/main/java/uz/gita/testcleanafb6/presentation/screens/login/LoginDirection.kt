package uz.gita.testcleanafb6.presentation.screens.login

import uz.gita.testcleanafb6.presentation.navigator.AppNavigator
import uz.gita.testcleanafb6.presentation.screens.register.RegisterScreen
import javax.inject.Inject
import javax.inject.Singleton

interface LoginDirection {
    suspend fun moveToRegisterScreen()
    suspend fun moveToMainScreen()
}
@Singleton
class LoginDirectionImp @Inject constructor(private val appNavigator: AppNavigator):LoginDirection{
    override suspend fun moveToRegisterScreen() {
        appNavigator.navigateTo(RegisterScreen())

    }

    override suspend fun moveToMainScreen() {

    }

}