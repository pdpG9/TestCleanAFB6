package uz.gita.testcleanafb6.domain.usecase.imp

import kotlinx.coroutines.flow.Flow
import uz.gita.testcleanafb6.domain.models.AuthResponseParam
import uz.gita.testcleanafb6.domain.repository.AuthRepository
import uz.gita.testcleanafb6.domain.usecase.LogOutUseCase
import javax.inject.Inject

class LogOutUseCaseImp @Inject constructor(private val repository: AuthRepository):LogOutUseCase {
    override fun invoke(name: String, password: String): Flow<AuthResponseParam> = repository.logout(name, password)
}