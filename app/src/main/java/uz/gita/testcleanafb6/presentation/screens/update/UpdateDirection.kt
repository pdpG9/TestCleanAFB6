package uz.gita.testcleanafb6.presentation.screens.update

import uz.gita.testcleanafb6.presentation.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface UpdateDirection {

    suspend fun back()

}

@Singleton
class UpdateDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : UpdateDirection {
    override suspend fun back() {
        appNavigator.back()
    }

}