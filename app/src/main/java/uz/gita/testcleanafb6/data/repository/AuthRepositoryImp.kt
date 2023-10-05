package uz.gita.testcleanafb6.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.testcleanafb6.data.local.pref.MySharedPref
import uz.gita.testcleanafb6.data.mappers.mapToAuthResponseParam
import uz.gita.testcleanafb6.data.models.UserModel
import uz.gita.testcleanafb6.data.network.api.AuthApi
import uz.gita.testcleanafb6.data.network.request.AuthRequest
import uz.gita.testcleanafb6.domain.models.AuthResponseParam
import uz.gita.testcleanafb6.domain.repository.AuthRepository
import javax.inject.Inject


class AuthRepositoryImp @Inject constructor(
    private val api: AuthApi,
    private val pref: MySharedPref
) : AuthRepository {
    override fun login(name: String, password: String): Flow<AuthResponseParam> = flow {
        val response = api.login(AuthRequest(name, password))
        if (response.isSuccessful && response.body() != null) {
            pref.saveUser(UserModel(name, password, "${response.body()?.data?.token}"))
            emit(response.body()!!.mapToAuthResponseParam(true))
        }else{
            emit(response.body()!!.mapToAuthResponseParam(false))
        }
    }

    override fun register(name: String, password: String): Flow<AuthResponseParam> = flow {
        val response = api.register(AuthRequest(name, password))
        if (response.isSuccessful && response.body() != null) {
            pref.saveUser(UserModel(name, password, response.body()!!.data.token))
            emit(response.body()!!.mapToAuthResponseParam(true))
        }else{
            emit(response.body()!!.mapToAuthResponseParam(false))
        }
    }

    override fun logout(name: String, password: String): Flow<AuthResponseParam> = flow{
        val response = api.logOut(AuthRequest(name, password))
        if (response.isSuccessful && response.body() != null) {
            emit(AuthResponseParam(true,response.body()!!.message))
        }else{
            emit(AuthResponseParam(false,response.body()!!.message))
        }
    }

    override fun unRegister(name: String, password: String): Flow<AuthResponseParam> = flow {

    }
}