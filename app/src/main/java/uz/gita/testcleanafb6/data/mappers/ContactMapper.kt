package uz.gita.testcleanafb6.data.mappers

import uz.gita.testcleanafb6.data.network.response.AddContactResponse
import uz.gita.testcleanafb6.domain.models.ContactParam

fun AddContactResponse.toContactParam(isSuccess: Boolean): ContactParam =
    ContactParam(isSuccess, this.data)