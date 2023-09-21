package uz.gita.testcleanafb6.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.testcleanafb6.presentation.screens.login.LoginDirection
import uz.gita.testcleanafb6.presentation.screens.login.LoginDirectionImp
import uz.gita.testcleanafb6.presentation.screens.register.RegisterDirection
import uz.gita.testcleanafb6.presentation.screens.register.RegisterDirectionImp
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface DirectionModule {

    @Binds
    fun bindLoginDirection(imp: LoginDirectionImp): LoginDirection
    @Binds
    fun bindRegisterDirection(imp: RegisterDirectionImp):RegisterDirection
}