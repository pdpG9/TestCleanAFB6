package uz.gita.testcleanafb6.data.local.pref

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.gita.testcleanafb6.data.models.UserModel
import javax.inject.Inject

class MySharedPrefImpl @Inject constructor(@ApplicationContext context: Context) : MySharedPref {
    private val TOKEN = "TOKEN"
    private val USER_NAME = "USER_NAME"
    private val USER_PASSWORD = "USER_PASSWORD"
    private val STATUS_COLOR = "STATUS_COLOR"
    private val DEFAULT_TOKEN = ""
    private val DEFAULT_USER_NAME = ""
    private val DEFAULT_USER_PASSWORD = ""
    private val DEFAULT_STATUS_COLOR = Color.Black.toArgb()
    private val pref = context.getSharedPreferences("my", Context.MODE_PRIVATE)
    override fun getToken(): String {
        return getUser().token
    }

    override fun saveUser(userModel: UserModel) {
        pref.edit().putString(USER_NAME, userModel.name).apply()
        pref.edit().putString(USER_PASSWORD, userModel.password).apply()
        pref.edit().putString(TOKEN, userModel.token).apply()
    }

    override fun getUser() = UserModel(
        "${pref.getString(USER_NAME, DEFAULT_USER_NAME)}",
        "${pref.getString(USER_PASSWORD, DEFAULT_USER_PASSWORD)}",
        "${pref.getString(TOKEN, DEFAULT_TOKEN)}",
    )

    override fun clearData() {
        pref.edit().putString(USER_NAME,DEFAULT_USER_NAME).apply()
        pref.edit().putString(USER_PASSWORD, DEFAULT_USER_PASSWORD).apply()
        pref.edit().putString(TOKEN, DEFAULT_TOKEN).apply()
    }

    override fun saveStatusColor(color: Int) {
        pref.edit().putInt(STATUS_COLOR,color).apply()
    }

    override fun getStatusColor(): Int = pref.getInt(STATUS_COLOR,DEFAULT_STATUS_COLOR)

}