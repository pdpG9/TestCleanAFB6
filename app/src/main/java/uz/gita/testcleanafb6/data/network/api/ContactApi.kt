package uz.gita.testcleanafb6.data.network.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import uz.gita.testcleanafb6.data.network.request.AddContactRequest
import uz.gita.testcleanafb6.data.network.request.UpdateContactRequest
import uz.gita.testcleanafb6.data.network.response.AddContactResponse
import uz.gita.testcleanafb6.data.network.response.DeleteContactResponse
import uz.gita.testcleanafb6.data.network.response.GetAllContactsResponse
import uz.gita.testcleanafb6.data.network.response.GetContactByIdResponse
import uz.gita.testcleanafb6.data.network.response.UpdateContactResponse

interface ContactApi {
    @POST("/contact")
    suspend fun addContact(@Body addContactRequest: AddContactRequest): Response<AddContactResponse>

    @GET("/contact")
    suspend fun getAllContacts(): Response<GetAllContactsResponse>

    @PUT("/contact")
    suspend fun updateContact(@Body updateContactRequest: UpdateContactRequest): Response<UpdateContactResponse>

    @DELETE("/contact")
    suspend fun deleteContact(@Query("id") id: Int): Response<DeleteContactResponse>

    @GET("/contact/{id}")
    suspend fun getContactById(@Path("id") id: Int): Response<GetContactByIdResponse>
}