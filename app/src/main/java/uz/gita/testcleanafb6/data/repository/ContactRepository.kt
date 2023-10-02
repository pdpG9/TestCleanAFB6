package uz.gita.testcleanafb6.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.testcleanafb6.data.mappers.toContactParam
import uz.gita.testcleanafb6.data.network.api.ContactApi
import uz.gita.testcleanafb6.data.network.request.AddContactRequest
import uz.gita.testcleanafb6.domain.models.ContactParam
import uz.gita.testcleanafb6.domain.repository.ContactRepository
import javax.inject.Inject

class ContactRepository @Inject constructor(
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

}