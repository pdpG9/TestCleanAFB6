package uz.gita.testcleanafb6.presentation.navigator

import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.core.screen.Screen
typealias myScreen = AndroidScreen
interface AppNavigator {
    suspend fun navigateTo(screen: myScreen)
    suspend fun replace(screen: myScreen)
    suspend fun replaceAll(screen: myScreen)
    suspend fun back()
    suspend fun backToRoot(screen: myScreen)

}