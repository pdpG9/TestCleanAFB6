package uz.gita.testcleanafb6.data.mappers

import uz.gita.testcleanafb6.data.network.response.AuthResponse
import uz.gita.testcleanafb6.domain.models.AuthResponseParam

fun AuthResponse.mapToAuthResponseParam(isSuccess:Boolean):AuthResponseParam =
    AuthResponseParam(isSuccess,this.message)