package uz.gita.testcleanafb6.domain.usecase.imp

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.testcleanafb6.data.repository.ContactRepository
import uz.gita.testcleanafb6.domain.models.UpdateContactParam
import uz.gita.testcleanafb6.domain.usecase.UpdateContactUseCase
import javax.inject.Inject

class UpdateContactUseCaseImpl @Inject constructor(
    val repository: ContactRepository
):UpdateContactUseCase {
    override fun invoke(id:Int,name: String, phone: String): Flow<UpdateContactParam> = flow{
        repository.updateContact(id, name, phone)
    }
}