package uz.gita.testcleanafb6.di

import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import uz.gita.testcleanafb6.presentation.navigator.AppNavigator
import uz.gita.testcleanafb6.presentation.navigator.NavigationDispatcher
import uz.gita.testcleanafb6.presentation.navigator.NavigationHandler

val navigationModule = module {
    single<NavigationDispatcher> { NavigationDispatcher()}
    single<AppNavigator> {
        val dispatcher:NavigationDispatcher = get()
        dispatcher
    }
    single<NavigationHandler> {
        val dispatcher:NavigationDispatcher = get()
        dispatcher
    }
}