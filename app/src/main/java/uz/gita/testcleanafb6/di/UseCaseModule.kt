package uz.gita.testcleanafb6.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.testcleanafb6.domain.usecase.AddContactUseCase
import uz.gita.testcleanafb6.domain.usecase.LogOutUseCase
import uz.gita.testcleanafb6.domain.usecase.LoginUseCase
import uz.gita.testcleanafb6.domain.usecase.RegisterUseCase
import uz.gita.testcleanafb6.domain.usecase.imp.AddContactUseCaseImpl
import uz.gita.testcleanafb6.domain.usecase.imp.LogOutUseCaseImp
import uz.gita.testcleanafb6.domain.usecase.imp.LoginUseCaseImp
import uz.gita.testcleanafb6.domain.usecase.imp.RegisterUseCaseImp

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindLoginUseCase(imp:LoginUseCaseImp):LoginUseCase
    @Binds
    fun bindRegisterUseCase(imp:RegisterUseCaseImp):RegisterUseCase
    @Binds
    fun bindLogOutUseCase(imp:LogOutUseCaseImp):LogOutUseCase

    @Binds
    fun bindAddUseCase(imp: AddContactUseCaseImpl) : AddContactUseCase
}