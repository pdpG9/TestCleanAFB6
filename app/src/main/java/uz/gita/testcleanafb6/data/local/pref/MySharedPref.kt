package uz.gita.testcleanafb6.data.local.pref

import uz.gita.testcleanafb6.data.models.UserModel

interface MySharedPref {
    fun getToken():String
    fun saveUser(userModel: UserModel)
    fun getUser():UserModel
    fun clearData()
    fun saveStatusColor(color:Int)
    fun getStatusColor():Int
}