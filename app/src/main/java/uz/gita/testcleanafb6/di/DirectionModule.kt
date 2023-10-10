package uz.gita.testcleanafb6.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.testcleanafb6.presentation.screens.add.AddDirection
import uz.gita.testcleanafb6.presentation.screens.add.AddDirectionImpl
import uz.gita.testcleanafb6.presentation.screens.home.HomeDirection
import uz.gita.testcleanafb6.presentation.screens.home.HomeDirectionImp
import uz.gita.testcleanafb6.presentation.screens.login.LoginDirection
import uz.gita.testcleanafb6.presentation.screens.login.LoginDirectionImp
import uz.gita.testcleanafb6.presentation.screens.register.RegisterDirection
import uz.gita.testcleanafb6.presentation.screens.register.RegisterDirectionImp
import uz.gita.testcleanafb6.presentation.screens.splesh.SplashDirection
import uz.gita.testcleanafb6.presentation.screens.splesh.SplashDirectionImp
import uz.gita.testcleanafb6.presentation.screens.update.UpdateDirection
import uz.gita.testcleanafb6.presentation.screens.update.UpdateDirectionImpl
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface DirectionModule {

    @Binds
    fun bindLoginDirection(imp: LoginDirectionImp): LoginDirection
    @Binds
    fun bindRegisterDirection(imp: RegisterDirectionImp):RegisterDirection
    @Binds
    fun bindSplashDirection(imp: SplashDirectionImp): SplashDirection
    @Binds
    fun bindHomeDirection(imp: HomeDirectionImp): HomeDirection

    @Binds
    fun bindAddDirection(imp : AddDirectionImpl) : AddDirection

    @Binds
    fun bindUpdateDirection(impl : UpdateDirectionImpl) : UpdateDirection
}