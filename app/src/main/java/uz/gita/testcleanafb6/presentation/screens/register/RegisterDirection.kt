package uz.gita.testcleanafb6.presentation.screens.register

import uz.gita.testcleanafb6.presentation.navigator.AppNavigator
import uz.gita.testcleanafb6.presentation.screens.login.LoginDirection
import javax.inject.Inject
import javax.inject.Singleton

interface RegisterDirection {
    suspend fun back()
    suspend fun moveToMainScreen()
}
@Singleton
class RegisterDirectionImp @Inject constructor(private val appNavigator: AppNavigator):
    RegisterDirection {
    override suspend fun back() {
      appNavigator.back()
    }

    override suspend fun moveToMainScreen() {
//    appNavigator.navigateTo()
    }

}