package uz.gita.testcleanafb6.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.testcleanafb6.domain.models.ContactParam
import uz.gita.testcleanafb6.domain.models.DeleteContactParam
import uz.gita.testcleanafb6.domain.models.UpdateContactParam

interface ContactRepository {
    fun addContact(name:String, phone:String):Flow<ContactParam>

    fun deleteContact(id:Int):Flow<DeleteContactParam>

    fun updateContact(id:Int,name:String,phone: String):Flow<UpdateContactParam>

}