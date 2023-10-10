package uz.gita.testcleanafb6.presentation.screens.add

import uz.gita.testcleanafb6.presentation.navigator.AppNavigator
import uz.gita.testcleanafb6.presentation.screens.home.HomeScreen
import javax.inject.Inject
import javax.inject.Singleton

interface AddDirection {
    suspend fun moveToMainScreen()
}

@Singleton
class AddDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : AddDirection {
    override suspend fun moveToMainScreen() {
        appNavigator.replaceAll(HomeScreen())
    }

}

