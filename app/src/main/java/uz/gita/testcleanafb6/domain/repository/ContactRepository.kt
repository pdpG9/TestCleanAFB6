package uz.gita.testcleanafb6.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.testcleanafb6.data.models.ContactModel
import uz.gita.testcleanafb6.domain.models.ContactParam

interface ContactRepository {
    fun addContact(name:String, phone:String):Flow<ContactParam>

}