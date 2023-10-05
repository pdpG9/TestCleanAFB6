package uz.gita.testcleanafb6.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.testcleanafb6.domain.models.UpdateContactParam

interface UpdateContactUseCase {
    operator fun invoke(id:Int,name:String,phone:String): Flow<UpdateContactParam>
}