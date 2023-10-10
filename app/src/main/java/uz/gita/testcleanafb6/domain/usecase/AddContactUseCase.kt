package uz.gita.testcleanafb6.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.testcleanafb6.domain.models.ContactParam

interface AddContactUseCase {
    fun addContact(name: String, phone: String): Flow<ContactParam>
}