package uz.gita.testcleanafb6.domain.usecase.imp

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.testcleanafb6.data.repository.ContactRepository
import uz.gita.testcleanafb6.domain.models.DeleteContactParam
import uz.gita.testcleanafb6.domain.usecase.DeleteContactUseCase
import javax.inject.Inject

class DeleteContactUseCaseImpl @Inject constructor(
    val repository: ContactRepository
) :DeleteContactUseCase{
    override fun invoke(id: Int): Flow<DeleteContactParam> = flow {
        repository.deleteContact(id)
    }
}