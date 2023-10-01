package uz.gita.testcleanafb6.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.testcleanafb6.domain.models.AuthResponseParam

interface RegisterUseCase {
    operator fun invoke(name:String,password:String,confirmPassword:String): Flow<AuthResponseParam>
}