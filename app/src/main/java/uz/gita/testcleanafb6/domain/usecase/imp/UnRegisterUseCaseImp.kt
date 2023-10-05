package uz.gita.testcleanafb6.domain.usecase.imp

import kotlinx.coroutines.flow.Flow
import uz.gita.testcleanafb6.domain.models.AuthResponseParam
import uz.gita.testcleanafb6.domain.repository.AuthRepository
import uz.gita.testcleanafb6.domain.usecase.LogOutUseCase
import uz.gita.testcleanafb6.domain.usecase.UnRegisterUseCase
import javax.inject.Inject

class UnRegisterUseCaseImp @Inject constructor(private val repository: AuthRepository):UnRegisterUseCase {
    override fun invoke(name: String, password: String): Flow<AuthResponseParam>
    = repository.unRegister(name, password)
}