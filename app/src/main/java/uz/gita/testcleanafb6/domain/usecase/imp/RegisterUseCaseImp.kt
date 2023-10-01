package uz.gita.testcleanafb6.domain.usecase.imp

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import uz.gita.testcleanafb6.domain.models.AuthResponseParam
import uz.gita.testcleanafb6.domain.repository.AuthRepository
import uz.gita.testcleanafb6.domain.usecase.RegisterUseCase
import javax.inject.Inject

class RegisterUseCaseImp @Inject constructor(private val authRepository: AuthRepository) :
    RegisterUseCase {
    override fun invoke(
        name: String,
        password: String,
        confirmPassword: String
    ): Flow<AuthResponseParam>  = flow{
        if (password==confirmPassword){
         emit(authRepository.register(name, password).last())
        }else{
            emit(AuthResponseParam(false,"password does not equals confirm password!"))
        }
    }
}