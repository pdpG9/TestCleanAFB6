package uz.gita.testcleanafb6.domain.models

import uz.gita.testcleanafb6.data.network.response.AddContactData

data class ContactParam(
    val isSuccess: Boolean,
    val data: AddContactData
)