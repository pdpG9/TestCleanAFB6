package uz.gita.testcleanafb6.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.testcleanafb6.domain.models.ContactParam
import uz.gita.testcleanafb6.domain.models.DeleteContactParam

interface ContactRepository {
    fun addContact(name:String, phone:String):Flow<ContactParam>

    fun deleteContact(id:Int):Flow<DeleteContactParam>

}