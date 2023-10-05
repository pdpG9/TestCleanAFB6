package uz.gita.testcleanafb6.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.testcleanafb6.domain.models.AuthResponseParam

interface AuthRepository {
    fun login(name:String,password:String):Flow<AuthResponseParam>
    fun register(name:String,password:String):Flow<AuthResponseParam>
    fun logout(name:String,password:String):Flow<AuthResponseParam>
    fun unRegister(name: String, password: String) : Flow<AuthResponseParam>
}