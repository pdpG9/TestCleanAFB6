package uz.gita.testcleanafb6.domain.usecase.imp

import kotlinx.coroutines.flow.Flow
import uz.gita.testcleanafb6.domain.models.AuthResponseParam
import uz.gita.testcleanafb6.domain.repository.AuthRepository
import uz.gita.testcleanafb6.domain.usecase.LoginUseCase
import javax.inject.Inject

class LoginUseCaseImp @Inject constructor(private val authRepository: AuthRepository) :
    LoginUseCase {
    override fun execute(name: String, password: String): Flow<AuthResponseParam> =
        authRepository.login(name, password)
}