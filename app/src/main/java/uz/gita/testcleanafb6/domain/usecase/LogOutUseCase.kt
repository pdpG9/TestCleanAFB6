package uz.gita.testcleanafb6.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.testcleanafb6.domain.models.AuthResponseParam

interface LogOutUseCase {
    operator fun invoke(name:String,password:String):Flow<AuthResponseParam>
}