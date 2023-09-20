package uz.gita.testcleanafb6.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uz.gita.testcleanafb6.presentation.screens.login.LoginViewModel

val viewModelModule = module {
    viewModel { LoginViewModel() }
}