package uz.gita.testcleanafb6.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.testcleanafb6.domain.models.DeleteContactParam

interface DeleteContactUseCase {

    operator fun invoke(id:Int):Flow<DeleteContactParam>
}