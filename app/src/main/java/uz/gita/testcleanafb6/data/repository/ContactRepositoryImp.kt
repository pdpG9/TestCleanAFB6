package uz.gita.testcleanafb6.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.testcleanafb6.data.mappers.toContactParam
import uz.gita.testcleanafb6.data.mappers.toDeleteContactParam
import uz.gita.testcleanafb6.data.mappers.toUpdateContactParam
import uz.gita.testcleanafb6.data.network.api.ContactApi
import uz.gita.testcleanafb6.data.network.request.AddContactRequest
import uz.gita.testcleanafb6.data.network.request.UpdateContactRequest
import uz.gita.testcleanafb6.domain.models.ContactParam
import uz.gita.testcleanafb6.domain.models.DeleteContactParam
import uz.gita.testcleanafb6.domain.models.UpdateContactParam
import uz.gita.testcleanafb6.domain.repository.ContactRepository
import javax.inject.Inject

class ContactRepositoryImp @Inject constructor(
    private val api: ContactApi,
) : ContactRepository {
    override fun addContact(name: String, phone: String): Flow<ContactParam> = flow {
        val response = api.addContact(AddContactRequest(name, phone))
        if (response.isSuccessful && response.body() != null) {
            emit(response.body()!!.toContactParam(true))
        } else {
            emit(response.body()!!.toContactParam(false))
        }
    }

    override fun deleteContact(id: Int): Flow<DeleteContactParam> = flow {
        val response = api.deleteContact(id)
        if (response.isSuccessful && response.body() != null){
            emit(response.body()!!.toDeleteContactParam(true))
        }else{
            emit(response.body()!!.toDeleteContactParam(false))

        }
    }

    override fun updateContact(id:Int,name: String, phone: String): Flow<UpdateContactParam> = flow {
        val response = api.updateContact(UpdateContactRequest(id,name,phone))

        if(response.isSuccessful && response.body() !=null){
            emit(response.body()!!.toUpdateContactParam(true))
        }else{
            emit(response.body()!!.toUpdateContactParam(false))
        }
    }

}