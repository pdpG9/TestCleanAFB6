package uz.gita.testcleanafb6.domain.usecase.imp

import kotlinx.coroutines.flow.Flow
import uz.gita.testcleanafb6.data.repository.ContactRepository
import uz.gita.testcleanafb6.domain.models.ContactParam
import uz.gita.testcleanafb6.domain.usecase.AddContactUseCase
import javax.inject.Inject

class AddContactUseCaseImpl @Inject constructor(
    val repository: ContactRepository
) : AddContactUseCase {

    override fun addContact(name: String, phone: String): Flow<ContactParam> = repository.addContact(name, phone)

}