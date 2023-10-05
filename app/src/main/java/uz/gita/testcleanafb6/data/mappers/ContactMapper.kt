package uz.gita.testcleanafb6.data.mappers

import uz.gita.testcleanafb6.data.network.response.AddContactResponse
import uz.gita.testcleanafb6.data.network.response.DeleteContactResponse
import uz.gita.testcleanafb6.domain.models.ContactParam
import uz.gita.testcleanafb6.domain.models.DeleteContactParam

fun AddContactResponse.toContactParam(isSuccess: Boolean): ContactParam =
    ContactParam(isSuccess, this.data)

fun DeleteContactResponse.toDeleteContactParam(isSuccess: Boolean):DeleteContactParam =
    DeleteContactParam(isSuccess,this.message)