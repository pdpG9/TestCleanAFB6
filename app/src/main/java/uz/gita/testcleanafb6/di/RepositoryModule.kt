package uz.gita.testcleanafb6.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.testcleanafb6.data.repository.AuthRepositoryImp
import uz.gita.testcleanafb6.domain.repository.AuthRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @[Binds Singleton]
    fun bindAuthRepository(imp:AuthRepositoryImp):AuthRepository
}